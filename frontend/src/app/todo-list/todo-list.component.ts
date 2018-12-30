import { Component, OnInit, ViewChild } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { NgForm } from '@angular/forms';
import { Todo } from '../shared/todo.model';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {
  @ViewChild('form') todosForm: NgForm;

  constructor(private readonly apiClient: ApiClientService) { }

  ngOnInit() {
  }

  handleClick() {
    const todo: Todo = {
      completed: this.todosForm.value.todo.isCompleted,
      description: 'Check Me!',
    };
    this.apiClient.postTodo(todo).subscribe();
  }

}
