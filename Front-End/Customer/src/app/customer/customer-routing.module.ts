import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailsComponent } from './details/details.component';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';
import { ViewComponent } from './view/view.component';

const routes: Routes = [
  {
    path: 'details',
    component: DetailsComponent,
  },
  {
    path: 'create',
    component: CreateComponent,
  },
  {
    path: 'update/:id',
    component: UpdateComponent,
  },
  {
    path:'view/:id',
    component:ViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomerRoutingModule {}
