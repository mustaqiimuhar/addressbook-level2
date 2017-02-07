package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

	private String _example = "";
	private String _messageConstrains = "";
	private String _validationRegex = "";
	private String _value = "";
	private boolean _isPrivate;
	
	public Contact(String _example, String _messageConstrains, String _validationRegex, String _value,
			boolean _isPrivate) throws IllegalValueException {
		super();
		this._example = _example;
		this._messageConstrains = _messageConstrains;
		this._validationRegex = _validationRegex;
		this._value = _value;
		this._isPrivate = _isPrivate;
		
		String trimmedAddress = _value.trim();
		if(!ifValidContact(trimmedAddress)){
			throw new IllegalValueException(_messageConstrains);
		}
		this._value = trimmedAddress;
	}

	public String get_example() {
		return _example;
	}

	public void set_example(String _example) {
		this._example = _example;
	}

	public String get_messageConstrains() {
		return _messageConstrains;
	}

	public void set_messageConstrains(String _messageConstrains) {
		this._messageConstrains = _messageConstrains;
	}

	public String get_validationRegex() {
		return _validationRegex;
	}

	public void set_validationRegex(String _validationRegex) {
		this._validationRegex = _validationRegex;
	}

	public String get_value() {
		return _value;
	}

	public void set_value(String _value) {
		this._value = _value;
	}

	public boolean isPrivate() {
		return _isPrivate;
	}

	public void set_isPrivate(boolean _isPrivate) {
		this._isPrivate = _isPrivate;
	}

	/**
     * Returns true if a given string is a valid based on regex.
     */
	private boolean ifValidContact(String trim) {
		// TODO Auto-generated method stub
		return trim.matches(_validationRegex);
	}
	
	@Override
	public String toString(){
		return _value;
	}
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this._value.equals(((Address) other).get_value())); // state check
    }

    @Override
    public int hashCode() {
        return _value.hashCode();
    }	
}
