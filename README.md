# model-mapper
The main goal of this project is to explore basic features of
`ModelMapper`.

_References_: [Manual](http://modelmapper.org/user-manual/)  
_References_: [java doc](http://modelmapper.org/javadoc/)  
_References_: [How it works](http://modelmapper.org/user-manual/how-it-works/)  
_References_: [Configuration](http://modelmapper.org/user-manual/configuration/)

# technologies used
```
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>2.0.0</version>
</dependency>
```

# preface
Applications often consist of similar but different object models, 
where the data in two models may be similar but the structure and 
concerns of the models are different. Object mapping makes it easy 
to convert one model to another, allowing separate models to remain 
segregated.

# description
The goal of ModelMapper is to make object mapping easy, 
by automatically determining how one object model maps to another, 
based on conventions.

Model Mapper is:
* **Intelligent** - it analyzes your object model to intelligently 
determine how data should be mapped.

* **Convention Based** - it uses conventions to determine 
how properties and values are mapped to each other. 
What is more - users can create custom conventions.

* **Extensible** - it supports integration with any type of data model.

# defaults
* **Access level**: public - eligible for matching are only public 
methods and fields
* **Field matching**: disabled - only methods are eligible for matching
* **Naming convention**: JavaBeans
* **Name transformer**: JavaBeans
* **Name tokenizer**: Camel Case
* **Matching strategy**: Standard, which means that:
    * all destination properties be matched and 
    all source property names have at least one token matched,
    * tokens can be matched in any order.
    
# matching process
* **Eligibility** - only source methods with zero parameters and a 
non-void return type are eligible, and destination methods with one 
parameter and a void return type are eligible.

* **Transformation** - a source object with a `getPerson` method and a 
destination object with a `setPerson` method. In order for these to be 
matched, a `NameTransformer` is used to transform the method names to 
`person`.

* **Tokenization** - After transformation, NameTokenizers are used to 
tokenize class and property names for matching.

* **Matching** - match is based on properties' names and class 
name tokens.

* **Handling Ambiguity** -  it is possible that multiple source 
properties may match the same destination property. 
When this occurs, the matching engine attempts to resolve the 
ambiguity by finding the closest match among the duplicates.
If the ambiguity cannot be resolved, a 
`ConfigurationException` is thrown.

# manual