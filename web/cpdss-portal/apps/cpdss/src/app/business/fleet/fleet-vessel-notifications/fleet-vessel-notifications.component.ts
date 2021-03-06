import { AppConfigurationService } from './../../../shared/services/app-configuration/app-configuration.service';
import { IDateTimeFormatOptions } from './../../../shared/models/common.model';
import { TimeZoneTransformationService } from './../../../shared/services/time-zone-conversion/time-zone-transformation.service';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { IFleetNotificationResponse, IFleetNotifications } from '../models/fleet-map.model';

/**
 * This dummy data will remove once the API integrated
 */
const vesselNotificationsMock: IFleetNotificationResponse = {
  current: [
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-16',
      updatedDate: '19-05-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-15',
      updatedDate: '18-05-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-10',
      updatedDate: '19-04-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-5',
      updatedDate: '18-03-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-4',
      updatedDate: '15-03-2021 09:15'
    }
  ],
  all: [
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-16',
      updatedDate: '19-05-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-15',
      updatedDate: '18-05-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-10',
      updatedDate: '19-04-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-5',
      updatedDate: '18-03-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-4',
      updatedDate: '15-03-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-2',
      updatedDate: '12-03-2021 09:15'
    },
    {
      vesselName: 'KAZUSA',
      vesselId: 149,
      flag: '../../../../assets/images/flags/japan.png',
      status: 'Vessel confirmed loadable plan for LS-1',
      updatedDate: '12-03-2021 08:15'
    }
  ]
};

/**
 * Component to show the vessel notifications
 *
 * @export
 * @class FleetVesselNotificationsComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'cpdss-portal-fleet-vessel-notifications',
  templateUrl: './fleet-vessel-notifications.component.html',
  styleUrls: ['./fleet-vessel-notifications.component.scss'],
})
export class FleetVesselNotificationsComponent implements OnInit {

  @ViewChild('fleetNotificationDateRange') dateRangeFilter: any;

  vesselNotification: IFleetNotificationResponse;
  currentNotifications: IFleetNotifications[];
  allNotifications: IFleetNotifications[];
  isCurrent: boolean = true;
  searchKey: string;
  filteredDates: Date[];
  today = new Date();
  dateFormat: string;

  constructor(
    private timeZoneTransformationService: TimeZoneTransformationService
  ) { }

  ngOnInit(): void {
    this.initNotifications();
    this.dateFormat = AppConfigurationService?.settings?.dateFormat;
  }

  /**
   * function to load current & all notifications
   *
   * @memberof FleetVesselNotificationsComponent
   */
  initNotifications(): void {
    const formatOptions: IDateTimeFormatOptions = { stringToDate: true };
    let vesselNotifications = <IFleetNotificationResponse>{};
    vesselNotifications.current = vesselNotificationsMock.current.map(item => {
      item.dateTime = this.timeZoneTransformationService.formatDateTime(item.updatedDate, formatOptions);
      return item;
    });
    vesselNotifications.all = vesselNotificationsMock.all.map(item => {
      item.dateTime = this.timeZoneTransformationService.formatDateTime(item.updatedDate, formatOptions);
      return item;
    });
    this.vesselNotification = vesselNotifications;
    this.currentNotifications = this.vesselNotification.current;
    this.allNotifications = this.vesselNotification.all;
  }

  /**
   * function to switch notification tabs
   *
   * @param {string} type
   * @memberof FleetVesselNotificationsComponent
   */
  switchNotifications(type: string): void {
    this.isCurrent = type === 'current' ? true : false;
  }

  /**
   * function to filter notfications by date-range
   *
   * @memberof FleetVesselNotificationsComponent
   */
  onDateRangeSelect(): void {
    if (this.filteredDates[0] && this.filteredDates[1]) {
      this.dateRangeFilter.hideOverlay();
      this.searchVessel();
    }
  }

  /**
   * function to reset datae range filter
   *
   * @memberof FleetVesselNotificationsComponent
   */
  resetDateFilter() {
    this.searchVessel();
  }

  /**
   * function to search notifications by vessel-name
   *
   * @param {*} event
   * @memberof FleetVesselNotificationsComponent
   */
  searchVessel(): void {
    if (this.searchKey && this.filteredDates?.length === 2) {
      this.currentNotifications = [...this.vesselNotification.current].filter(item => {
        return item.vesselName.toLowerCase().includes(this.searchKey) && item.dateTime.getTime() >= this.filteredDates[0].getTime() && item.dateTime.getTime() <= this.filteredDates[1].getTime();
      });
      this.allNotifications = [...this.vesselNotification.all].filter(item => {
        return item.vesselName.toLowerCase().includes(this.searchKey) && item.dateTime.getTime() >= this.filteredDates[0].getTime() && item.dateTime.getTime() <= this.filteredDates[1].getTime();
      });
    } else if (!this.searchKey && this.filteredDates?.length === 2) {
      this.currentNotifications = [...this.vesselNotification.current].filter(item => {
        return item.dateTime.getTime() >= this.filteredDates[0].getTime() && item.dateTime.getTime() <= this.filteredDates[1].getTime();
      });
      this.allNotifications = [...this.vesselNotification.all].filter(item => {
        return item.dateTime.getTime() >= this.filteredDates[0].getTime() && item.dateTime.getTime() <= this.filteredDates[1].getTime();
      });
    } else if (this.searchKey && (this.filteredDates === null || this.filteredDates === undefined)) {
      this.currentNotifications = [...this.vesselNotification.current].filter(item => {
        return item.vesselName.toLowerCase().includes(this.searchKey)
      });
      this.allNotifications = [...this.vesselNotification.all].filter(item => {
        return item.vesselName.toLowerCase().includes(this.searchKey)
      });
    } else if (!this.searchKey && (this.filteredDates === null || this.filteredDates === undefined)) {
      this.currentNotifications = [...this.vesselNotification.current];
      this.allNotifications = [...this.vesselNotification.all];
    }
  }
}
