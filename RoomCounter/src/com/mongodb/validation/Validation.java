package com.mongodb.validation;

public class Validation {

	/**
	 * Check if the string is a valid input.
	 *
	 * Example:
	 * Validation.isValid(ValidTypesEnum.V_INTEGER, "123")
	 * ^ Checks if it's a valid integer.
	 *
	 * @param vt The type 'input' will be verified against: should it be an integer, date, etc?
	 * @param input The string input to be verified (Front end hands everything to us as a string)
	 * @return true if it is a valid example of the type provided, false otherwise.
	 */
	public static boolean isValid(ValidTypesEnum vt, String input) {
		switch(vt) {
		case V_INTEGER:
			return isValidInteger(input);
		case V_STRING:
			return isValidString(input);
		case V_DATE:
			return isValidDate(input);
		case V_TIME:
			return isValidTime(input);
		default: // Makes your compiler happy, even though we should never ever get here
			return false;
		}
	}

	private static boolean isInt(char c) {
		return ( '0' <= c && c <= '9' );
	}

	/**
	 * Check if input is a valid integer represented as a string.
	 * @param input A string potentially containing an integer.
	 * @return True if it is a string containing only an integer, false otherwise.
	 */
	private static boolean isValidInteger(String input) {
		for(char c : input.toCharArray())
			if( !isInt(c) ) return false;

		// If we got here, it must only contain 0...9, so we're good
		return true;
	}

	/**
	 * Check if input is a valid string (has no SQL injection stuff).
	 * @param input A string that may have malicious SQL in it.
	 * @return True if string appears to be safe.
	 */
	private static boolean isValidString(String input) {
		for(char c : input.toCharArray()) {
			// Checking for common characters used in SQL injection
			switch(c) {
			case '\'': return false;
			case '*' : return false;
			case '=' : return false;
			case '`' : return false;
			case ';' : return false;
			case ':' : return false;
			case '+' : return false;
			case '.' : return false;
			case '\"': return false;
			}
		}

		// If we got here, it must not contain any of those SQL injection characters, so we're good
		return true;
	}

	/**
	 * Check if input is a valid date represented by a string.
	 * @param input A string that should represent a date in format DD/MM/YYYY
	 * @return True if input does represent a date in DD/MM/YYYY, false otherwise.
	 */
	private static boolean isValidDate(String input) {
		int intcount   = 0;
		int slashcount = 0;
		for(char c : input.toCharArray()) {
			if( isInt(c) ) {
				intcount++;
			} else if ( c == '/') {
				slashcount++;
			} else {
				return false; // If we're here we've got something that isn't an integer or a slash- not valid!
			}

			if(slashcount > intcount) {
				return false;
			}
		}

		return true;
		// TODO- this gets rid of most but not all cases, so find a cleaner way to do this.
	}

	/**
	 * Check if input is a valid time represented by a string.
	 * @param input A string that should represent a time in format HH:MM.
	 * @return True if input does represent a time in HH:MM, false otherwise.
	 */
	private static boolean isValidTime(String input) {
		int timeLength = input.length();

		// It might be 4 characters (9:45), it might be 5 characters (10:45), it can't be anything else.
		if( !(timeLength == 4 || timeLength == 5) ) return false;

		for(int i = timeLength; i < 0; --i) {
			if( !isInt(input.charAt(i))) {
				if( !(i == ':' && i == timeLength-2) ) // We know that the length-2 will be a colon, but can't guarantee counting from the other direction.
					return false;
			}
		}
		return true;
	}
}
