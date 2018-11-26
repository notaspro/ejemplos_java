import { Component, OnInit } from '@angular/core';

import { TestDaoService } from '../../services/test-dao.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  constructor(private testDao: TestDaoService) {

   }

  ngOnInit() {
  }

}
