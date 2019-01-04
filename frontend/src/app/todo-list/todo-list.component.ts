import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { ApiClientService } from '../api-client.service';
import { Todo } from '../shared/todo.model';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {
  @ViewChild('form') todosForm: NgForm;
  todos: Observable<Todo[]>;

  constructor(private readonly apiClient: ApiClientService) { }

  ngOnInit() {
    this.todos = this.apiClient.getTodos();
  }

  handleClick(todoIndex: number) {
    const todo = this.todosForm.value.todos[todoIndex];
    if (todo.id) {
      this.apiClient.putTodo(todo).subscribe();
    } else {
      this.apiClient.postTodo(todo).subscribe(todoWithId => {
        this.todosForm.form.get(`todo.${todoIndex}.id`).patchValue(todoWithId.id);
      });
    }
  }

}
