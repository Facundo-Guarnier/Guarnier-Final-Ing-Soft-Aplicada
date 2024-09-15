// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthService {
//   private apiUrl = 'http://localhost:8080/api/authenticate';
//   // {
//   //   "id_token" : "eyJh..."
//   // }

//   constructor(private http: HttpClient) { }

//   login(): Observable<any> {
//     const credentials = {
//       username: 'admin',
//       password: 'admin'
//     };

//     return this.http.post(this.apiUrl, credentials);
//   }
// }