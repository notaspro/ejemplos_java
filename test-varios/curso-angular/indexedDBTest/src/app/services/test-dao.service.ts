import { Injectable, OnInit } from '@angular/core';

import { AngularIndexedDB } from './angular2-indexeddb';
import { Persona } from './../model/persona';

@Injectable({
  providedIn: 'root'
})
export class TestDaoService implements OnInit {

  DB_NAME = 'AppTestDb';
  STORE_NAME = 'personas';
  daoIndexedDB: AngularIndexedDB;

  constructor() {
    console.error('Ejecutando TestDaoService.constructor()...');
    this.daoIndexedDB = new AngularIndexedDB(this.DB_NAME, 1);
      // this.daoIndexedDB = new AngularIndexedDB('AppTestDb', 1);
      this.daoIndexedDB.openDatabase(1, (evt) => {
        let objectStore = evt.currentTarget.result.createObjectStore(
          this.STORE_NAME, { keyPath: 'id', autoIncrement: true}
        );
        objectStore.createIndex('id', 'id', { unique: true });
        objectStore.createIndex('email', 'email', { unique: true });
      });

    }

    ngOnInit() {


    }

    getAll(): Promise<Persona[]> {
      console.error('Ejecutando TestDaoService.getAll()...');
      return this.daoIndexedDB.getAll(this.STORE_NAME).then((personas) => {
        console.log(personas);
        return personas;
      }).catch(this.handleError);
    }

    findById(personId: string ): Promise<Persona> {
      console.error('Ejecutando TestDaoService.findById()...');
        // return this.daoIndexedDB.getByKey(this.STORE_NAME, personId);
        return this.daoIndexedDB.getByKey(this.STORE_NAME, personId).then((persona) => {
          console.log(persona);
          return persona;
        }).catch(this.handleError);
    }

    save(personData: Persona): Promise<any> {
      console.error('Ejecutando TestDaoService.save()...');
      return this.daoIndexedDB.add(this.STORE_NAME, personData, 1).then(() => {
        return Promise.resolve();
      }).catch(this.handleError);
    }

    private handleError(error: any) {
      console.error('Ocurrio un error', error);
      return Promise.reject(error.message || error);
  }
}
