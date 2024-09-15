import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

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
  

  constructor(
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.folder = this.activatedRoute.snapshot.paramMap.get('id') as string;

    //! USUARIOS
    if (this.folder === 'usuarios') {
      this.getApi('admin/users').subscribe(
        (response) => {
          console.log('Usuarios cargados:', response);
          this.users = response;
        },
        (error) => {
          console.error('Error al cargar usuarios:', error);
        }
      );

    //! AUTORES
    } else if (this.folder === 'autores') {
      // http://localhost:8080/api/authors?size=20&sort=id,esc
    //   [ {
    //     "id" : 1,
    //     "firstName" : "Chelsie",
    //     "lastName" : "Thompson"
    //   }, {
    //     ...
    //   } ]
      
      this.getApi('authors?size=20&sort=id,asc').subscribe(
        (response) => {
          console.log('Autores cargados:', response);
          this.authors = response;
        },
        (error) => {
          console.error('Error al cargar autores:', error);
        }
      );

    //! MI PERFIL
    } else if (this.folder === 'mi-perfil') {
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
      this.getApi('account').subscribe(
        (response) => {
          console.log('Mi perfil cargado:', response);
          this.mi_data = response;
        },
        (error) => {
          console.error('Error al cargar mi perfil:', error);
        }
      );
    }
  }

  private getApi(url:string): Observable<any> {
    //GEt a la api + el token del localstorage
    let heads = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Access-Control-Allow-Origin', '*')
      .set('Authorization', 'Bearer ' + localStorage.getItem('jwt'));

    return this.http.get('http://localhost:8080/api/' + url, { headers: heads });

  }
}