package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractType;
import ca.uhn.log.HapiLogFactory;

/**
 * <p>The HL7 UVC (UB Value Code and Amount) data type.  Consists of the following components: </p><ol>
 * <li>Value Code (CNE)</li>
 * <li>Value Amount (MO)</li>
 * </ol>
 */
public class UVC extends AbstractType implements Composite {

	private Type[] data;

	/**
	 * Creates a UVC.
	 * @param message the Message to which this Type belongs
	 */
	public UVC(Message message) {
		super(message);
		data = new Type[2];
		data[0] = new CNE(message);
		data[1] = new MO(message);
	}

	/**
	 * Returns an array containing the data elements.
	 */
	public Type[] getComponents() { 
		return this.data; 
	}

	/**
	 * Returns an individual data component.
	 * @throws DataTypeException if the given element number is out of range.
	 */
	public Type getComponent(int number) throws DataTypeException { 

		try { 
			return this.data[number]; 
		} catch (ArrayIndexOutOfBoundsException e) { 
			throw new DataTypeException("Element " + number + " doesn't exist in 2 element UVC composite"); 
		} 
	} 
	/**
	 * Returns Value Code (component #0).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public CNE getValueCode() {
	   CNE ret = null;
	   try {
	      ret = (CNE)getComponent(0);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns Value Amount (component #1).  This is a convenience method that saves you from 
	 * casting and handling an exception.
	 */
	public MO getValueAmount() {
	   MO ret = null;
	   try {
	      ret = (MO)getComponent(1);
	   } catch (DataTypeException e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem accessing known data type component - this is a bug.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}