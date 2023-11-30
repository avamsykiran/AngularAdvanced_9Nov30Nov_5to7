import { Component, Input,Output,EventEmitter } from '@angular/core';
import { NavLink } from '../nav-link';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  @Input()
  title: string;

  @Input()
  links!:NavLink[];

  @Input()
  hideLogout!:boolean;

  @Output()
  logoutClick:EventEmitter<void>;

  constructor() {
    this.title="UnKnown";
    this.logoutClick=new EventEmitter<void>();
  }

  triggerLogoutClickEvent(){
    this.logoutClick.emit();
  }

}
