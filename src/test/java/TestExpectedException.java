import org.junit.Test;

import org.postgresql.util.PSQLException;

import ru.dolgiy.model.UserKnowledgeManagement;




/**
 * Created by Anton on 16.02.2016.
 */

public class TestExpectedException {
    @Test(expected = PSQLException.class)
    public void TestExpectException()throws java.lang.Exception{
        //adding line with not-unique primary key
        UserKnowledgeManagement.getInstance().addNewTechnology(201,"ggg","fff");

    }
}

