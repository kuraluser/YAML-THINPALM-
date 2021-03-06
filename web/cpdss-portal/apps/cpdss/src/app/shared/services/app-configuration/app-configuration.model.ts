import { IDictionary, QUANTITY_UNIT } from '../../models/common.model';

export interface IAppConfiguration {
  apiUrl: string;
  keycloakUrl: string;
  path: string;
  redirectPath: string;
  clientId: string;
  baseUnit: QUANTITY_UNIT;
  volumeBaseUnit: QUANTITY_UNIT;
  permissionMapping?: IDictionary<string>;
  passwordMinLength?: number;
  processingTimeout?: number;
  tokenMinValidity?: number;
  dateFormat?: string;
  quantityNumberFormatKL?: string;
  quantityNumberFormatBBLS?: string;
  quantityNumberFormatMT?: string;
  quantityNumberFormatOBSBBLS?: string;
  quantityNumberFormatLT?: string;
  defaultWeightUnit: QUANTITY_UNIT;
  defaultRateUnit: QUANTITY_UNIT;
  maxFillingPercentage: string;
  sgNumberFormat: string;
  ullageUnit: string;
  restrictMaxNumberOfCargo?: boolean;
  maxCargoLimit?: number;
  vesselNoImageUrl: string;
  minimapPinIconUrl: string;
  unitConversionConstant: number;
  documentationSiteMapping?: IDictionary<string>;
  obqBaseUnit: QUANTITY_UNIT;
  obqDefaultWeightUnit: QUANTITY_UNIT;
}

