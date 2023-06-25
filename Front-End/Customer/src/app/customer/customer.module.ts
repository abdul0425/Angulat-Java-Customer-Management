import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DetailsComponent } from './details/details.component';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';
import { CustomerRoutingModule } from './customer-routing.module';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { ViewComponent } from './view/view.component';

@NgModule({
  declarations: [DetailsComponent, CreateComponent, UpdateComponent, ViewComponent],
  imports: [CommonModule,CustomerRoutingModule,FormsModule,RouterModule],
  exports: [DetailsComponent, CreateComponent, UpdateComponent,ViewComponent],
})
export class CustomerModule {}
