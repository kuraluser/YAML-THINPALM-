import { Component, Input, OnInit } from '@angular/core';

/**
 * Component class for trim condition
 *
 * @export
 * @class TrimConditionComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-trim-condition',
  templateUrl: './trim-condition.component.html',
  styleUrls: ['./trim-condition.component.scss']
})
export class TrimConditionComponent implements OnInit {

  @Input() trim: number;
  @Input() hogSag: number;

  constructor() { }

  ngOnInit(): void {
  }

}