import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserAddComponent } from './components/user-add/user-add.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { UserListComponent } from './components/user-list/user-list.component';

const routes: Routes = [
  {path: 'users', component: UserListComponent},
  {path: 'users/:id', component: UserDetailsComponent},
  {path: 'users/add', component: UserAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
