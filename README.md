# Password Validation
Java library for Password Validation for use with Bean Validation Api.
It provides many constraint to deal with password validation and many more 
will be added in near future:

1. ContainDigit: To validate if password contain specified number of digits.
2. ContainLowercase: To validate if password contain specified number of lowercase.
3. ContainSpecial: To validate if password contain specified number of special symbols.
4. ContainUppercase: To validate if password contain specified number of uppercase. 
5. NotContainWhitespace: To validate should not have any whitespace.
6. PasswordMatches: To validate if password and confirm password are equal. You can move
   also move constraint to confirm password field by using flag showErrorOnConfirmPassword
   (default is true).
   
All the constraints by default ignore blank so that it will be reported separately by NotBlank 
standard bean validation constraint and same can we turned of using ignoreBlank(true by default) 
flag of each constraint.

Small example to use the library is:
   
   <pre>
   <code>
   @PasswordMatches
   public class PasswordDto {
       @Size(min = 8, max = 30)
       @NotContainWhitespace
       @ContainSpecial
       @ContainDigit
       private String password;
       @NotBlank
       private String confirmPassword;
   }
   </code>
   </pre>

You can use it very easily just by adding the following maven coordinates
in your project:
<dependency>
    <groupId>com.github.ankurpathak.password</groupId>
    <artifactId>password-validation</artifactId>
    <version>1.0.3</version>
</dependency>
