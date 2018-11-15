package com.gonzasilve.puntoventas.pvfront.utils;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.regexp.internal.RESyntaxException;


/**
 * @author Banco Azteca S.A. [JFAV] Septiembre 12, 2008.
 *
 * En esta clase se deber&aacute; concentrar todos los formateos de Banca Elite
 * para texto, n&uacute;meros y fechas. Adem�s de contener las constantes
 * auxiliares para la aplicaci&oacite;n como pueden d&iacute;s, meses y
 * a&ntilde;os.
 */
public class Formatter {

	private static final Logger $log = Logger.getLogger(Formatter.class);

	private static DecimalFormat decimalFormat = null;

	private static DecimalFormat decimalFormatSimple = null;

	public static final Collection<String> DIAS = getDias();

	public static final Collection<String> MESES = getMeses();

	public static final Collection<String> ANIOS = getAnios();

	public static String FECHA_ACTUAL = getFechaActual();

	final static String NBSP = "&nbsp;";

	private static DateFormatSymbols symbols = new DateFormatSymbols();

	private static DateFormat dateFormat = new SimpleDateFormat( "d MMM yyyy", symbols );

	final static String[] AMPM = { "am", "pm" };
	final static String[] MONTHS = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre", "" };
	final static String[] WEEKDAYS = { "", "Domingo", "Lunes", "Martes", "Mi�rcoles", "Jueves", "Viernes", "S�bado" };
	final static String[] SHORT_MONTHS = { "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic", "" };
	final static String[] SHORT_WEEKDAYS = { "", "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab" };
	private static DateFormat dateFormatEbank = null;

	static {
		decimalFormat = new DecimalFormat( "###,###,##0.00" );
		decimalFormatSimple = new DecimalFormat( "########0.00" );

		DateFormatSymbols symbols = new DateFormatSymbols();
		symbols.setAmPmStrings( AMPM );
		symbols.setMonths( MONTHS );
		symbols.setShortMonths( SHORT_MONTHS );
		symbols.setWeekdays( WEEKDAYS );
		symbols.setShortWeekdays( SHORT_WEEKDAYS );
		dateFormatEbank = new SimpleDateFormat( "d MMM yyyy", symbols );

	}

	public static String formatFechaEbank( Date fecha ) {
		if( fecha == null ) return NBSP;
		return dateFormatEbank.format( fecha );
	}

	public static String formatFecha( Date fecha ) {
		if( fecha == null ) return NBSP;
		return dateFormat.format( fecha );
	}

	public static String formatNegativo( BigDecimal monto ) {
		double data = 0;
		BigDecimal uno = new BigDecimal(-1);
		if( monto != null ) {
			monto = monto.multiply(uno);
			data = monto.doubleValue();
		}
		return formatMonto( data );
	}

	private static Collection<String> getDias() {
		Collection<String> dias = new ArrayList<String>();
		for (int i = 0; i <= 31; i++) {
			dias.add(String.valueOf(i));
		}
		return dias;
	}

	private static final Collection<String> getMeses() {
		Collection<String> meses = new ArrayList<String>();
		String[] $meses = { "Enero", "Ferbero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
		for (String string : $meses) {
			meses.add(string);
		}
		return meses;
	}

	private static Collection<String> getAnios() {

		return null;
	}

	private static String formatDayMonthYear(Date fecha) {
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sDF = new SimpleDateFormat(pattern);
		return sDF.format(fecha);
	}

	private static String getFechaActual() {
		return formatDayMonthYear(new Date());
	}

	public static String formatCuenta( String cuenta ) {
		if( (cuenta != null) && (cuenta.length() == 20) )
			return cuenta.substring( 4, 8 ).concat( cuenta.substring( 10, 20 ) );
		else if(cuenta != null && cuenta.length() == 14)
			return cuenta;
		else if (cuenta != null && cuenta.length() < 14){
			StringBuffer temp = new StringBuffer();
			for(int i = 0; i < 14-cuenta.length(); i++){
				temp.append("0");
			}
			temp.append(cuenta);
			return temp.toString();
		}
		return NBSP;
	}

	public static double conversionMontoAlnovaJava(String montoAlnova){
		double montoConvertido = 0.0;

		if( ( montoAlnova != null ) && ( montoAlnova.length() > 1 ) ){
			int longitud = montoAlnova.length();
			String decimales = montoAlnova.substring(longitud-2, longitud);
			String enteros = montoAlnova.substring(0, longitud-2);
			String montoParceado = enteros + "." + decimales;
			montoConvertido = Double.parseDouble(montoParceado);
		}
		return montoConvertido;
	}

	/**
	 * Juan Luis Uriel Rodriguez Peralta
	 *
	 * Dado un numero de cuenta de 14 digitos, se obtiene le antepone 0127 como
	 * clave del banco, y despues de los primeros 4 digitos de la cuenta recibida
	 * se agrega el digito verificador (2 digitos), que en conjunto forman un
	 * numero de 18 cifras.
	 * @param 01000115033553
	 * @return 012701000115033553
	 */
	public static String getNumeroCuenta18(String cuenta14) {
		return "0127" + cuenta14.substring(0, 4) + cuenta14.substring(4);
	}

	public static String formatMonto( BigInteger monto ) {
		StringBuffer buffer = new StringBuffer(decimalFormat.format(monto));
		if (buffer.length() >= 4) {
			buffer.deleteCharAt(buffer.length() -1 );
			buffer.deleteCharAt(buffer.length() -1 );
			buffer.deleteCharAt(buffer.length() -1 );
		}
		if( monto != null ) {

			if( monto.compareTo(BigInteger.ZERO) < 0 ) {
				buffer.insert( 0, "<font color=\"red\">" );
				buffer.append( "</font>" );
			}
		}
		return buffer.toString();
	}

	public static String formatMontoPesos( double monto ) {
		StringBuffer buffer = new StringBuffer( "$ " + decimalFormat.format( monto ) );
		if( monto < 0 ) {
			buffer.insert( 0, "<font color=\"red\">" );
			buffer.append( "</font>" );
		}
		return buffer.toString();
	}

	public static String formatMontoPesos( String importe ) {
		if((importe!=null)&&(importe.length()>0)){
			Double monto=Double.parseDouble(importe);
			Locale LOCALE_MX = new Locale("es","mx");
			NumberFormat numberFormat=DecimalFormat.getInstance(LOCALE_MX);
			numberFormat.setMinimumFractionDigits(2);

			importe = new String( "$ " + numberFormat.format( monto ) );
			if( monto < 0 ) {
				importe = new String( "$ " + numberFormat.format( 0.00 ) );
			}
		}
		return importe;
	}

	public static String formatMonto( double monto ) {
		StringBuffer buffer = new StringBuffer( decimalFormat.format( monto ) );
		return buffer.toString();
	}

	public static String formatMonto( BigDecimal monto ) {
		StringBuffer buffer = new StringBuffer("0.00");
		if(monto!=null){
			buffer = new StringBuffer( decimalFormatSimple.format( monto ) );
		}

		return buffer.toString();
	}

	public static String formatMontoTruncado( String monto ) {
		StringBuffer buffer = new StringBuffer("0.00");
		if(!Validator.isEmptyData(monto)){
			if(Validator.checkNumericBalance(monto)){
				Double importe = new Double(monto);
				buffer = new StringBuffer( decimalFormatSimple.format( importe ) );
			}
		}
		return buffer.toString();
	}

	public static String formatSplittedCuenta( String cuenta ){
		String cuentaFormateada = formatCuenta(cuenta);
		if(cuentaFormateada.equals("&nbsp;")){
			return formatAccountAnotherBank( cuenta );
		}else{
			return split4CharsTokens( cuentaFormateada );
		}

	}

	public static String formatSplittedCuentaClabe( String cuentaClabe ){
		return split4CharsTokens( cuentaClabe );
	}

	public static String formatSplittedTarjeta( String tarjeta ) {
		return split4CharsTokens( tarjeta );
	}

	public static String formatXXCuenta(String cuenta){
		int cuentaLength = cuenta.length();
		StringBuffer buffer = new StringBuffer(cuentaLength);
		for(int i = 0; i < cuentaLength - 4; i++){
			buffer.append("X");
			if( ( (i+3) % 4) == 0 ){
				buffer.append(" ");
			}
		}
		buffer.append(cuenta.substring(cuentaLength-4));
		return buffer.toString();
	}

	public static String formatXXTarjeta(String tarjeta){
		tarjeta = removeSpaces(tarjeta);
		int tarjetaLength = tarjeta.length();
		StringBuffer buffer = new StringBuffer(tarjetaLength);
		for(int i = 0; i < tarjetaLength - 4; i++){
			buffer.append("X");
			if( ( (i+1) % 4) == 0 ){
				buffer.append(" ");
			}
		}
		buffer.append(tarjeta.substring(tarjetaLength-4));
		return buffer.toString();
	}

	public static String split4CharsTokens(String param){
		try {
			if( param != null ) {
				if( param.length() == 16 ) {
					return param.substring(0,4)+" "+param.substring(4,8)+" "+
						param.substring(8,12)+" "+param.substring(12,16);
				} else if ( param.length() == 14 ){
					return param.substring(0,4)+" "+param.substring(4,8)+" "+
						param.substring(8,12)+" "+param.substring(12,14);
				} else if ( param.length() == 17 && param.indexOf(" ")!=-1){
					return param.substring(0,4)+" "+param.substring(4,6)+
						param.substring(7,9)+" "+param.substring(9,13)+" "+
						param.substring(13,17);
				} else if ( param.length() == 18 ){
					return param.substring(0,4)+" "+param.substring(4,8)+ " " +
						param.substring(8,12)+" "+param.substring(12,16)+" "+
						param.substring(16,18);
				} else{
					return param;
				}
			} else {
				return "";
			}
		} catch(Exception e){
			$log.info("Formatter falla en split4CharsTokens ->"+
				param+" "+e.getMessage());
			return param;
		}
	}

	public static String removeSpaces( String item ) {
		if (item == null)
			return "";
		char[] chs = item.toCharArray();
		StringBuffer cta = new StringBuffer();
		for ( int i=0;i<chs.length;i++ ){
			if ( !Character.isSpaceChar( chs[i] ) ){
				cta.append(chs[i]);
			}
		}
		return cta.toString();
	}

	public static String removeSpacesLeftRight( String item ) {
		if (item == null){
			return "";
		}
		item = item.replaceAll("^( )*", "");
		item = item.replaceAll("( )*$", "");

		return item;
	}

	public static String formatName(String name)
	{
		String formatName = "";
		if(name == null || name.trim().length()<1)
			return formatName;
		else
		{
			String []words = name.trim().split(" ");
			for (String aux : words)
				if(aux.trim().length() > 0)
				formatName = formatName.concat(" "+aux);
			return formatName;
		}
	}

	/*
	public static boolean checkEMail(String data){
		boolean flag = false;
		if (data != null && data.trim().length()!=0){
			try {
				RE re = new RE("^[a-zA-Z](-|[a-zA-Z0-9\\._])*[a-zA-Z0-9]@[a-zA-Z0-9](-|[a-zA-Z0-9\\._])*[a-zA-Z0-9][\\.][a-zA-Z](-|[a-zA-Z0-9\\._])*[a-zA-Z]$");
				flag = re.match(data.trim());
			} catch (RESyntaxException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	*/

	public static String getReportName(String cuenta, String periodo){
		StringBuffer fileName = new StringBuffer();
		String separador = "_";
		String extension = ".csv";

		fileName.append("EdoCta");
		fileName.append(separador);
		fileName.append(cuenta.substring(14, 17));
		fileName.append(separador);
		String[] array = periodo.split(" ");
		fileName.append(formatSimpleDate(array[0]));
		fileName.append(separador);
		fileName.append(formatSimpleDate(array[2]));
		fileName.append(extension);

		return fileName.toString();
	}

	private static String formatSimpleDate(String fecha){
		String[] cads = fecha.split("-");
		String mes = cads[1];
		String numero = "";

		if (mes.equalsIgnoreCase("enero"))
			numero = "01";
		if (mes.equalsIgnoreCase("febrero"))
			numero = "02";
		if (mes.equalsIgnoreCase("marzo"))
			numero = "03";
		if (mes.equalsIgnoreCase("abril"))
			numero = "04";
		if (mes.equalsIgnoreCase("mayo"))
			numero = "05";
		if (mes.equalsIgnoreCase("junio"))
			numero = "06";
		if (mes.equalsIgnoreCase("julio"))
			numero = "07";
		if (mes.equalsIgnoreCase("agosto"))
			numero = "08";
		if (mes.equalsIgnoreCase("septiembre"))
			numero = "09";
		if (mes.equalsIgnoreCase("octubre"))
			numero = "10";
		if (mes.equalsIgnoreCase("noviembre"))
			numero = "11";
		if (mes.equalsIgnoreCase("diciembre"))
			numero = "12";
		return cads[0] + "-" + numero + "-" + cads[2];
	}


	private static String formatAccountAnotherBank(String param){
		try {
			if( param != null ) {
				int tamanoParam = param.length();
				int index = 0;
				String bloque = "";
				String formatParam = "";
				while (index < (tamanoParam-1)) {
					if((index+4) < (tamanoParam-1)){
						bloque = param.substring(index, (index+4)) + " ";
					}else{
						bloque = param.substring(index, tamanoParam);
					}
					formatParam = formatParam + bloque;
					index = index + 4;
				}
				return formatParam;
			} else {
				return "";
			}
		} catch(Exception e){
			$log.info("Formatter falla en split4CharsTokens ->"+
				param+" "+e.getMessage());
			return param;
		}
	}

	public static String formatDate(String date){

		try{

			if(date == null){
				return date;
			}else if(date.length() != 10 ){
				if(date.length()!=9){
					return date;
				}
			}
			String anio, dia;
			int mes;
			if(date.charAt(2) == '-'){
				dia = date.substring(0,2);
				mes = Integer.parseInt(date.substring(3,5));
				anio = date.substring(6,10);
			}else{
				anio = date.substring(0, 4);
				if(date.length()==10){
					mes = Integer.parseInt(date.substring(5, 7));
					dia = date.substring(8, 10);
				}else{
					mes = Integer.parseInt(date.substring(5, 6));
					dia = date.substring(8, 9);
				}

			}

			switch(mes){
			case 1:{
				return dia+" Ene "+anio;
			}case 2:{
				return dia+" Feb "+anio;
			}case 3:{
				return dia+" Mar "+anio;
			}case 4:{
				return dia+" Abr "+anio;
			}case 5:{
				return dia+" May "+anio;
			}case 6:{
				return dia+" Jun "+anio;
			}case 7:{
				return dia+" Jul "+anio;
			}case 8:{
				return dia+" Ago "+anio;
			}case 9:{
				return dia+" Sep "+anio;
			}case 10:{
				return dia+" Oct "+anio;
			}case 11:{
				return dia+" Nov "+anio;
			}case 12:{
				return dia+" Dic "+anio;
			}default:{
				return date;
			}
			}
		}catch(Exception e){
			return date;
		}
	}

	@SuppressWarnings("deprecation")
	public static String formatoFechaHora(String fechaUltimoMovimiento){

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		String format = sdf.format(new Date(fechaUltimoMovimiento));

		String hora = fechaUltimoMovimiento.substring(11, 16);
        String meridiano = (Integer.parseInt(hora.substring(0,2))<= 12 ? "AM" : "PM");

        fechaUltimoMovimiento = formatDate(format.substring(0, 10))+ " " + hora + " " + meridiano;

		return fechaUltimoMovimiento;

	}

	public static String[] periodoMesActual(){

		String fechas[]= new String[2];
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formato2 = new SimpleDateFormat("yyyy/MM/");
		String fechaHoy= formato.format(fechaActual);
		String pimerDiaMes = formato2.format(fechaActual)+"01";
		fechas[0]=pimerDiaMes;
		fechas[1]=fechaHoy;

		return fechas;
	}

	@SuppressWarnings("deprecation")
	public static String formatoFechaReportos(String fecha){
		String fechaFormateada = "";
		String[] token = fecha.split("/");
		int anio = 100 + Integer.parseInt(token[0]);
		int mes = Integer.parseInt(token[1])-1;
		int dia = Integer.parseInt(token[2]);
		Date date = new Date(anio, mes, dia);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		fecha = simpleDateFormat.format(date);
		fechaFormateada = formatDate(fecha);
		return fechaFormateada;
	}

	public static String getCodigoErrorAlnova(String respuestaAlnova){
		int inicio = respuestaAlnova.indexOf("(");
		int fin = respuestaAlnova.indexOf(")")+1;
		String codigo = respuestaAlnova.substring(inicio, fin);
		return codigo;
	}

	public static String getMontoTruncado(String monto, int numeroDecimales){
		String montoSeparado[] = monto.split("[.]");
		if(montoSeparado.length>1){
			if(montoSeparado[1].length() > numeroDecimales){
				monto = montoSeparado[0]+"."+montoSeparado[1].substring(0,numeroDecimales);
			}
		}else{
			String decimales = "";
			for(int i=0; i<numeroDecimales; i++){
				decimales += "0";
			}
			monto = monto+"."+decimales;
		}
		return monto;
	}

	public static String getMontoTruncadoExponente(String monto, int numeroDecimales){
		String montoSeparado[] = monto.split("[E]");
		if(montoSeparado.length>1){
			if(montoSeparado[1].length() > numeroDecimales){
				monto = montoSeparado[0]+"."+montoSeparado[1].substring(0,numeroDecimales);
			}
		}else{
			String decimales = "";
			for(int i=0; i<numeroDecimales; i++){
				decimales += "0";
			}
			monto = monto+"."+decimales;
		}
		return monto;
	}

	public static String formatMonto(String importe) {
		if ((importe != null) && (importe.length() > 0)) {

			String montoSeparado[] = importe.split("[.]");

			int entero = Integer.parseInt(montoSeparado[0]);
			Locale LOCALE_MX = new Locale("es", "mx");
			NumberFormat numberFormat = DecimalFormat.getInstance(LOCALE_MX);

			importe = new String("$ " + numberFormat.format(entero));

			if (montoSeparado.length > 1) {
				importe += "." + montoSeparado[1];
			} else{
				importe += ".00";
			}

		}
		return importe;
	}
	/**
	 * @author
	 * Formato para fecha ej: de 15  NOVIEMBRE 2009 A 15 Nov 2009
	 */public static String formatoFecha(String fecha){
		 	fecha = fecha.replaceAll("\t", " ");
		 	fecha = fecha.replaceAll(" ( )* ", " ");
			String fechaArreglo[]= fecha.split(" ");
			String mes=fechaArreglo[1].substring(0,3);
			fecha=fechaArreglo[0]+" "+mes.substring(0,1)+mes.substring(1,3).toLowerCase()+" "+fechaArreglo[2];
			return fecha;

		}

	 	public static String formatFecha(String format,Date date){
	 		SimpleDateFormat sdf= new  SimpleDateFormat(format);
	 		return sdf.format(date);
	 	}

	 	public static String formatAlnovaAccount(String acc14Digits){
	 		
	 		if(acc14Digits.length() == 20)
	 			return acc14Digits;
	 		getDigits("0127",acc14Digits);
			StringBuffer buffer = new StringBuffer("0127");
	        buffer.append(acc14Digits.substring(0, 4));
	        buffer.append(getDigits("0127",acc14Digits));
	        buffer.append(acc14Digits.substring(4, 14));
	        acc14Digits = buffer.toString();
			return acc14Digits;
		}
	 	
	 	public static void main(String[] args) {
	 		System.out.println("cuenta ::: " + formatAlnovaAccount("01720197800083")); 
		}

		public static String getDigits( String entity, String stdAcc ) throws NumberFormatException {

			stdAcc = stdAcc.trim();
			if( stdAcc.length() != 14 ) throw new IllegalArgumentException( "stdAcc.length() != 14" );

			StringBuffer buffer = new StringBuffer( entity );
			buffer.append( stdAcc.substring( 0, 4 ) );
			buffer.insert( 0, getDigit( buffer.toString().toCharArray(), 2, 0 ) ); // 1st digit
			buffer.setLength( 1 );
			buffer.append( getDigit( stdAcc.substring( 4, 14 ).toCharArray(), 0, 0 ) ); // 2nd digit
			return buffer.toString();
		}

		public static long getDigit( char[] subStr, int idx, int accum ) throws NumberFormatException {
			final int[] base = { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };

			int total = subStr.length;
	 		int iTemp = 0;
			for( int curr = 0; curr < total; curr++ ) {
				iTemp = Integer.parseInt( String.valueOf( subStr[ curr ] ) );
				iTemp *= base[ idx++ ];
				accum += iTemp;
			}
			BigDecimal bdAccum = BigDecimal.valueOf( accum );
			BigDecimal bd11 = BigDecimal.valueOf( 11 );
			BigDecimal bdTemp = bdAccum.divide( bd11, BigDecimal.ROUND_DOWN );
			bdTemp = bdTemp.multiply( bd11 );
			bdTemp = bdAccum.subtract( bdTemp );
			long lTemp = bdTemp.longValue();
			if( (lTemp != 0) && (lTemp != 1) ) lTemp = 11 - lTemp;
			return lTemp;
		}

		public static Date stringToDateInv(String strDate){
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date fecha = null;
			try {
			    fecha = format.parse(strDate);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			return fecha;
		}

		public static Date stringToDate(String strDate){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = null;
			try {

			    fecha = format.parse(strDate);

			} catch (Exception e) {
			    e.printStackTrace();
			}
			return fecha;
		}
		
		
		// UTILIDADES PARA CONVERTIR MX A USD
		public String convertToUSD(String importe, String tipoCambio) {
			String importeDLS = String.valueOf((new BigDecimal(importe))
					.doubleValue()
					/ (new BigDecimal(tipoCambio)).doubleValue());
			return String.valueOf(convertMonto(importeDLS, 0, 4));
		}
		public BigDecimal convertMonto(String monto, int decimales,
				int maximumFraction) {
			BigDecimal data = null;
			double divisor = Math.pow(10, decimales);
			try {
				data = new BigDecimal(monto);
				data = data.divide(new BigDecimal(divisor), maximumFraction,
						BigDecimal.ROUND_DOWN);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return data;
		}
		
		public String substract(String importe1, String importe2) {
			String importeDLS = String.valueOf((new BigDecimal(importe1))
					.subtract(new BigDecimal(importe2)));
			return String.valueOf(convertMonto(importeDLS, 0, 4));
		}
		
		public static String deleteWhiteSpaces(String cadena)
		{
			String text="";
			StringTokenizer stTexto = new StringTokenizer(cadena);
			while (stTexto.hasMoreElements())
				text += stTexto.nextElement();
			return text;
		}
		
		public static  int getDiaFecha(Date fecha)
		{
			Calendar c = Calendar.getInstance();
			c.setTime(fecha);
			int i= c.get(Calendar.DATE);
			return i;
		}
		
		 public static boolean validaMail(String input) {
			 
			 // comprueba que no empieze por punto o @
		      Pattern p = Pattern.compile("^@");
		      Matcher m = p.matcher(input);
		      if (m.find())
		      {
		         System.err.println("Las direcciones email no empiezan por punto o @");
		         return true;
		      }
		      // comprueba que no empieze por www.
		      p = Pattern.compile("^www.");
		      m = p.matcher(input);
		      if (m.find())
		      {
		    	  System.err.println("Los emails no empiezan por www");
		        return true;
		      }
		      // comprueba que contenga @
		      p = Pattern.compile("@");
		      m = p.matcher(input);
		      if (!m.find())
		      {
		    	  System.err.println("La cadena no tiene arroba");
		      	return true;
		      }
		      // comprueba que no contenga caracteres prohibidos
		      p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
		      m = p.matcher(input);
		      StringBuffer sb = new StringBuffer();
		      boolean resultado = m.find();
		      boolean caracteresIlegales = false;

		      while(resultado) {
		         caracteresIlegales = true;
		         m.appendReplacement(sb, "");
		         resultado = m.find();
		      }

		      // A�ade el ultimo segmento de la entrada a la cadena
		      m.appendTail(sb);

		      input = sb.toString();

		      if (caracteresIlegales) {
		    	  System.err.println("La cadena contiene caracteres ilegales");
		         return true;
		      }
		      return false;
		   }
		 
		 public static String formatAccountNumber( String account ) {
				StringBuffer temp = new StringBuffer();
				if(account != null && account.length() == 14)
					return account;
				else if( (account != null) && (account.length() == 20) )
					return account.substring( 4, 8 ).concat( account.substring( 10, 20 ) );
				else if (account != null && account.length() < 14){
					temp = new StringBuffer();
					for(int i = 0; i < 14-account.length(); i++){
						temp.append("0");
					}
					temp.append(account);

				}
				return temp.toString();
			}

		 
			public static boolean isNumeric(String data) {
				boolean flag = false;
				if(!isNullOrEmpty(data)){
					try {
						RE re = new RE( "^(\\d+)$" );
						flag = re.match(data.trim());
					} catch(RESyntaxException e) {
						e.printStackTrace();
					}
				}
				return flag;
			}
			
			public static boolean isNullOrEmpty (Object data){		
				boolean flag = false;
				if( isNull(data) ){
					flag = true;
				}else {
					String stringData = String.valueOf( data );
					if( stringData.trim().isEmpty() ){
						flag = true;
					}
				}		
				return flag;
			}
			
			public static boolean isNull(Object data){
				boolean flag = false;
				if(data == null){
					flag = true;
				}		
				return flag;		
			}
			
			/**
			 * @author hb
			 * @description Este metodo cambia el base 64 de una imagen de cualquier formato a tiff, 
			 * y despues regresa el base64 de la imagen en formato tiff
			 */
			@SuppressWarnings("deprecation")
			public static String cambiaImagenATiff( String base64, HttpServletRequest request ){
				SecureRandom random = new SecureRandom();
				try {
					byte[] byts = new BASE64Decoder().decodeBuffer( base64 );
					
					String idImg = new BigInteger(62, random).toString(32);
					FileOutputStream fileOutputStream = null;
					BufferedOutputStream bufferedOutputStream = null;
					boolean escribio = false;
					try {
						//Escribir imagen en tiff
						fileOutputStream = new FileOutputStream( new File(request.getRealPath("/")+"resources"+File.separator+"images"+File.separator+idImg+".tiff") );
						bufferedOutputStream = new BufferedOutputStream( fileOutputStream );
						bufferedOutputStream.write(byts);
						escribio = true;
					} catch (Exception e) {
						// TODO: handle exception
					}finally{
						// releases any system resources associated with the stream
			            if(fileOutputStream!=null)
			            	fileOutputStream.close();
			            if(bufferedOutputStream!=null)
			            	bufferedOutputStream.close();
					}
					
					if( escribio ){
						FileInputStream fileInputStream = null;
						BufferedInputStream bufferedInputStream = null;
						byte[] buf = null;
						try {
							fileInputStream = new FileInputStream(  new File(request.getRealPath("/")+"resources"+File.separator+"images"+File.separator+idImg+".tiff") );
							bufferedInputStream = new BufferedInputStream( fileInputStream );
							int numByte = bufferedInputStream.available();
							buf = new byte[numByte];
							bufferedInputStream.read(buf);
						} catch (Exception e) {
							// TODO: handle exception
						}finally{
							if(fileInputStream!=null)
				            	fileInputStream.close();
				            if(bufferedInputStream!=null)
				            	bufferedInputStream.close();
				            
				            File tiff = new File(request.getRealPath("/")+"resources"+File.separator+"images"+File.separator+idImg+".tiff");
				            if( tiff.exists() ){
				            	if( tiff.delete() ){
				            		//Archivo temporal eliminado correctamente
				            	}else{
				            		//No se elimin[o el archivo
				            	}
				            }
						}
					}
					    
				} catch (IOException e) {
					// Error en el proceso de convertir imagen a tiff
					e.printStackTrace();
				}		
				return base64;
			}

}
