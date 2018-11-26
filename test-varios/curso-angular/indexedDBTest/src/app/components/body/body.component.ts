
import { Component, Input, OnInit } from '@angular/core';

import { TestDaoService } from '../../services/test-dao.service';
import {Persona} from '../../model/persona';


@Component({
    selector: 'app-body',
    templateUrl: './body.component.html'
    // providers: [TestDaoService]
})
export class BodyComponent implements OnInit {
    @Input() persona: Persona;
    personas: Persona[];
    mostrarCita: boolean;
    idiomas: string[];

    mensaje: any = {
        autor: 'Gonzalo Silverio',
        mensaje: 'Ganar no lo es todo, es lo único.'
    };

    constructor(public testDaoService: TestDaoService ) {
    // constructor() {
        this.mostrarCita = true;
        this.idiomas = ['Español', 'Ingles', 'Frances'];
        this.persona = new Persona();
    }

    ngOnInit() {
        this.testDaoService.getAll().then(personas => this.personas = personas);
    }

    save() {
        this.testDaoService
            .save(this.persona)
            .then( console.log )
            .catch( console.log ); // TODO: Display error message
    }
}
