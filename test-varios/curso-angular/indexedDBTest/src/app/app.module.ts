import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BodyComponent } from './components/body/body.component';
import { FooterComponent } from './components/footer/footer.component';
import { UsuarioComponent } from './components/usuario/usuario.component';

import { AngularIndexedDB } from './services/angular2-indexeddb';
import { TestDaoService } from './services/test-dao.service';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BodyComponent,
    FooterComponent,
    UsuarioComponent
  ],
  imports: [BrowserModule, FormsModule],
  providers: [
    AngularIndexedDB, TestDaoService
    ],
  bootstrap: [AppComponent]
})
export class AppModule {}
