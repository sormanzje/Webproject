/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.webproject.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
//import org.springframework.beans.BeanUtils;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author tothda
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{

    private String firstFieldName;
    private String secondFieldName;
    private String message;
    
    
    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        
        try{
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
            
            valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception e){
            System.out.println(e.toString());
        }
        
        if(!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }
        
        return valid;
        
    }
    
}
