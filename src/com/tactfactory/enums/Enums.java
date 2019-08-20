package com.tactfactory.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Enums {

	public static void main(String[] args) {
//		DataType dataType = DataType.DATA_TYPE_1;
//		if (dataType == DataType.DATA_TYPE_2) {
//			//do
//		}
//
//		DataType dataType = DataType.DATA_TYPE_1;
//		switch (dataType) {
//		case DATA_TYPE_1:
//			System.out.println(dataType);
//			break;
//		case DATA_TYPE_2:
//			System.out.println(dataType);
//			break;
//		default:
//			break;
//		}

//		System.out.println(DataType.DATA_TYPE_1);
//		System.out.println(DataType.DATA_TYPE_1.label);
//		System.out.println(DataType.DATA_TYPE_1.dataDefaultValue);
//		System.out.println(DataType.valueOfLabel("données de type 1"));

		for (Entry<String, DataType> data : DataType.dataTypeMap.entrySet()) {
			System.out.println(data.getKey() + " " + data.getValue());
		}
	}

	public enum DataType {
		DATA_TYPE_1("données de type 1", 123659L),
		DATA_TYPE_2("autre données", 992332L);

		private static final Map<String, DataType> dataTypeMap = new HashMap<>();

		static {
	        for (DataType e: values()) {
	        	dataTypeMap.put(e.label, e);
	        }
	    }

	    public final String label;
	    public final Long dataDefaultValue;

	    private DataType(String label, Long dataDefaultValue) {
	        this.label = label;
	        this.dataDefaultValue = dataDefaultValue;
	    }

	    public static DataType valueOfLabel(String label) {
	        for (DataType e : values()) {
	            if (e.label.equals(label)) {
	                return e;
	            }
	        }
	        return null;
	    }


	}

}
