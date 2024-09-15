import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

interface User {
  login: string;
  email: string;
}
interface Authors {
  firstName: string;
  lastName: string;
}

@Component({
  selector: 'app-folder',
  templateUrl: './folder.page.html',
  styleUrls: ['./folder.page.scss'],
})
export class FolderPage implements OnInit {
  public folder!: string;
  public users: User[] = [];
  public authors: Authors[] = [];
  public mi_data: any = {};
  private activatedRoute = inject(ActivatedRoute);

  constructor() {}

  ngOnInit() {
    this.folder = this.activatedRoute.snapshot.paramMap.get('id') as string;

    if (this.folder === 'usuarios') {
      // http://localhost:8080/api/admin/users?size=20&sort=id,esc
      // [ {
      //   "id" : 1,
      //   "login" : "admin",
      //   "firstName" : "Administrator",
      //   "lastName" : "Administrator",
      //   "email" : "admin@localhost",
      //   "imageUrl" : "",
      //   "activated" : true,
      //   "langKey" : "en",
      //   "createdBy" : "system",
      //   "createdDate" : null,
      //   "lastModifiedBy" : "system",
      //   "lastModifiedDate" : null,
      //   "authorities" : [ "ROLE_USER", "ROLE_ADMIN" ]
      // }, {
      //   ...
      // }]

      this.users = [
        { login: 'Usuario 1', email: 'usuario1@ejemplo.com' },
        { login: 'Usuario 2', email: 'usuario2@ejemplo.com' },
        { login: 'Usuario 3', email: 'usuario3@ejemplo.com' },
        { login: 'Usuario 4', email: 'usuario4@ejemplo.com' },
      ];
    }
    if (this.folder === 'autores') {
      // http://localhost:8080/api/authors?size=20&sort=id,esc
    //   [ {
    //     "id" : 1,
    //     "firstName" : "Chelsie",
    //     "lastName" : "Thompson"
    //   }, {
    //     ...
    //   } ]
      
        this.authors = [
          { firstName: 'Chelsie', lastName: 'Thompson' },
          { firstName: 'Derrick', lastName: 'Garza' },
          { firstName: 'Hilda', lastName: 'Gibson' },
          { firstName: 'Lena', lastName: 'Horton' },
        ];
    }

    if (this.folder === 'mi-perfil') {
      // http://localhost:8080/api/account 
      // {
      //   "id" : 1,
      //   "login" : "admin",
      //   "firstName" : "Administrator",
      //   "lastName" : "Administrator",
      //   "email" : "admin@localhost",
      //   "imageUrl" : "",
      //   "activated" : true,
      //   "langKey" : "en",
      //   "createdBy" : "system",
      //   "createdDate" : null,
      //   "lastModifiedBy" : "system",
      //   "lastModifiedDate" : null,
      //   "authorities" : [ "ROLE_USER", "ROLE_ADMIN" ]
      // }

      this.mi_data = {
        login: 'admin',
        email: 'admin@localhost',
        firstName: 'Administrator',
        lastName: 'Administrator',
        authorities: ['ROLE_USER', 'ROLE_ADMIN'],
      };
    }
  }
}