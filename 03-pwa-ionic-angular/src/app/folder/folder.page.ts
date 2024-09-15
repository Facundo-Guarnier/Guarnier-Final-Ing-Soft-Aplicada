import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

interface User {
  name: string;
  email: string;
}

@Component({
  selector: 'app-folder',
  templateUrl: './folder.page.html',
  styleUrls: ['./folder.page.scss'],
})
export class FolderPage implements OnInit {
  public folder!: string;
  public users: User[] = [];
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
        { name: 'Usuario 1', email: 'usuario1@ejemplo.com' },
        { name: 'Usuario 2', email: 'usuario2@ejemplo.com' },
        { name: 'Usuario 3', email: 'usuario3@ejemplo.com' },
        { name: 'Usuario 4', email: 'usuario4@ejemplo.com' },
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
    }
  }
}