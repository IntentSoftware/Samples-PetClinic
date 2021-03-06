import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { OwnersService } from 'src/app/api-access/owners-service.service';
import { OwnerDTO } from './../../api-access/models/owner.dto';
import { IntentIgnore, IntentIgnoreBody, IntentManage } from './../../intent/intent.decorators';

@Component({
  selector: 'app-owner-list',
  templateUrl: './owner-list.component.html',
  styleUrls: ['./owner-list.component.scss']
})
export class OwnerListComponent implements OnInit {
  owners: OwnerDTO[];

  //@IntentCanAdd()
  constructor(private router: Router, private ownersService: OwnersService) { }

  @IntentIgnore()
  ngOnInit() {
    this.ownersService.getOwners()
      .subscribe(result => this.owners = result);
  }

  @IntentManage()
  onSelected(ownerId: number): void {
    // write your business logic here for this command
  }

  @IntentManage()
  goToAdd(): void {
    this.router.navigate(["owners", "add"]);
  }

  @IntentManage()
  goToDetails(id: any): void {
    this.router.navigate(["owners", id]);
  }

}
