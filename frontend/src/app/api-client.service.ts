import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from './shared/todo.model';

@Injectable({ providedIn: 'root' })
export class ApiClientService {
  constructor(private httpClient: HttpClient) { }

  getHelloWorld(name: string = ''): Observable<string> {
    return this.httpClient.get(`/api/hello-world/${name}`, { responseType: 'text' });
  }

  getTodos(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>('api/todos');
  }

  putTodo(todo: Todo): Observable<Todo> {
    return this.httpClient.put<Todo>(`/api/todos/${todo.id}`, todo);
  }

  postTodo(todo: Todo): Observable<Todo> {
    return this.httpClient.post<Todo>('/api/todos', todo);
  }
}
