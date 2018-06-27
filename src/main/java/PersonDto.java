import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Created by mtumilowicz on 2018-06-27.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
class PersonDto {
    String firstName;
    int age;
    String city;
    String street;
}
