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
    const { isCompleted: completed, id } = this.todosForm.value.todo;
    const todo: Todo = {
      completed,
      id,
      description: 'Check Me!',
    };
    if (todo.id) {
      this.apiClient.putTodo(todo).subscribe();
    } else {
      this.apiClient.postTodo(todo).subscribe(todoWithId => {
        this.todosForm.form.get('todo.id').patchValue(todoWithId.id);
      });
    }
  }

}
