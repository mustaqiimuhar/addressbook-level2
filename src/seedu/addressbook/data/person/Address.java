package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

	public static final String EXAMPLE = "a/123, Jurong East 123, #12-103, 600700";
	public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be formatted as:"
			+ " a/BLOCK, STREET, UNIT, POSTAL_CODE";
	public static final String ADDRESS_VALIDATION_REGEX = ".+";
	public static final String ADDRESS_DELIMITER = ",";

	public String value;
	private boolean isPrivate;

	public Block block;
	public Street street;
	public Unit unit;
	public PostalCode postalCode;

	/**
	 * Validates given address.
	 *
	 * @throws IllegalValueException
	 *             if given address string is invalid.
	 */
	public Address(String address, boolean isPrivate) throws IllegalValueException {
		String trimmedAddress = address.trim();
		this.isPrivate = isPrivate;
		if (!isValidAddress(trimmedAddress)) {
			throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
		}
		String[] splitAddress = trimmedAddress.split(ADDRESS_DELIMITER);
		initAddressClass(splitAddress);
		// this.value = trimmedAddress;

	}

	/**
	 * Initialize all the address sub class
	 * 
	 * @param splitAddress trimmed address to insert into respective subclass
	 */
	public void initAddressClass(String[] splitAddress) {
		block = new Block(splitAddress[0]);
		street = new Street(splitAddress[1]);
		unit = new Unit(splitAddress[2]);
		postalCode = new PostalCode(splitAddress[3]);
	}

	/**
	 * Returns true if a given string is a valid person email.
	 */
	public static boolean isValidAddress(String address) {
		return hasCorrectNoArguments(address);
	}
	

	/**
	 * to check if the number of address parameters equals to format
	 * 
	 * @param trimmedAddress
	 * @return true if the number of parameters equals to format required
	 */
	public static boolean hasCorrectNoArguments(String trimmedAddress) {
		String[] splitAddress = trimmedAddress.split(ADDRESS_DELIMITER);
		if (splitAddress.length == 4) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		value = block.getBlockNo() + "," + street.get_street() + "," + unit.get_unit() + ","
				+ postalCode.get_postalCode();
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Address // instanceof handles nulls
						&& this.toString().equals(((Address) other).toString())); // state
																				// check
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	public boolean isPrivate() {
		return isPrivate;
	}
}
