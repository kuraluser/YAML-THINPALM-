/**
 * Interface for formcontrol errors
 */
export interface IValidationErrors {
    [key: string]: any;
};

/**
 * Interface for formcontrol error messages
 */
export interface IValidationErrorMessages {
    [key: string]: string;
};

/**
 * Interface for all field error messages
 *
 * @export
 * @interface IValidationErrorMessagesSet
 */
export interface IValidationErrorMessagesSet {
  [key: string]: IValidationErrorMessages;
};
