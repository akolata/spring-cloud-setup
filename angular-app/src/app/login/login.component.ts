import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      username: '',
      password: ''
    });
  }

  onLogin() {
    const params = new URLSearchParams();
    params.append('username', this.loginForm.get('username').value);
    params.append('password', this.loginForm.get('password').value);
    params.append('grant_type', 'password');

    this.http.post(`${environment.api}/uaa/oauth/token`, params.toString(), {
    // this.http.post(`http://localhost:9000/oauth/token`, params.toString(), {
      headers: this.buildHttpHeaders()
    }).subscribe(res => {
      console.log(res);
    })
  }

  private buildHttpParams(): HttpParams {
    return new HttpParams()
      .set('username', this.loginForm.get('username').value)
      .set('password', this.loginForm.get('password').value)
      .set('grant_type', 'password')
      .set('client_id', 'angularClient');
  }

  private buildHttpHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Basic ' + btoa("angularClient:angularSecret")
    });
  }

}
