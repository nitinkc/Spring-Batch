package com.learning.batchprocessing;

import com.learning.batchprocessing.model.User;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * Created by nitin on Wednesday, February/05/2020 at 11:27 PM
 */
@Component
public class UserFieldMapper implements FieldSetMapper<User> {

    @Override
    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        User user = new User();
        user.setFirstName(fieldSet.readString("first_name"));
        user.setLastName(fieldSet.readString("last_name"));
        return user;
    }
}
