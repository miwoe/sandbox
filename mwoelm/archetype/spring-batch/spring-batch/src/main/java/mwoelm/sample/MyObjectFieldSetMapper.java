package mwoelm.sample;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class MyObjectFieldSetMapper implements FieldSetMapper<MyObject>{

	public MyObject mapFieldSet(FieldSet arg0) throws BindException {

		return new MyObject();
	}

}
