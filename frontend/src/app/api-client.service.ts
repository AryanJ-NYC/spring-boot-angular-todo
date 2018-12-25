import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ApiClientService {
  constructor(private httpClient: HttpClient) { }

  getHelloWorld(name = ''): Observable<string> {
    return this.httpClient.get(`/api/hello-world/${name}`, { responseType: 'text' });
  }
}
