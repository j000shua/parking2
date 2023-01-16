import { Component } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {

  user?: User;

  constructor(private userService: UserService) {}

  retrieveUser(): void {
    this.userService.get(1)
      .subscribe({
        next: (data) => {
          this.user = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      })
  }
}
