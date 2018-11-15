@RestController
class HelloWorld {
	
  @RequestMapping("/")
  String hello() {
    "Hello JournalDev World.<br>https://www.journaldev.com/7969/spring-boot-tutorial"
  }
  
}