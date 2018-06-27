import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by mtumilowicz on 2018-06-27.
 */
class PersonToPersonDto {
    @Test
    void map() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Person.class, PersonDto.class)
                .addMapping(Person::getName, PersonDto::setFirstName)
                .addMapping(x -> x.getAddress().getCity(), PersonDto::setCity)
                .addMapping(x -> x.getAddress().getStreet(), PersonDto::setStreet);


        PersonDto personDto = modelMapper.map(Person.builder()
                        .name("Michal")
                        .age(15)
                        .address(new Address("Warsaw", "Nowy Swiat"))
                        .build(),
                PersonDto.class);

        assertEquals("Michal", personDto.getFirstName());
        assertEquals(15, personDto.getAge());
        assertEquals("Warsaw", personDto.getCity());
        assertEquals("Nowy Swiat", personDto.getStreet());
    }

    @Test
    void map2() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Person.class, PersonDto.class)
                .addMapping(Person::getName, PersonDto::setFirstName)
                .addMapping(x -> x.getAddress().getCity(), PersonDto::setCity)
                .addMapping(x -> x.getAddress().getStreet(), PersonDto::setStreet);


        PersonDto personDto = modelMapper.map(Person.builder()
                        .name("Michal")
                        .age(15)
                        .address(null)
                        .build(),
                PersonDto.class);

        assertEquals("Michal", personDto.getFirstName());
        assertEquals(15, personDto.getAge());
        assertNull(personDto.getCity());
        assertNull(personDto.getStreet());
    }

    @Test
    void map3() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Person.class, PersonDto.class)
                .<String>addMapping(Person::getEmail, (x, y) -> x.getContact().setEmail(y))
                .<String>addMapping(Person::getPhone, (x, y) -> x.getContact().setPhone(y));


        PersonDto personDto = modelMapper.map(Person.builder()
                        .email("michal@gmail.com")
                        .phone("123")
                        .build(),
                PersonDto.class);

        assertEquals("michal@gmail.com", personDto.getContact().getEmail());
        assertEquals("123", personDto.getContact().getPhone());
    }
}
