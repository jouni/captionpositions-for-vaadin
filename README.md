# CaptionPositions add-on for Vaadin

`CaptionPositions` is a layout extension add-on for Vaadin 7 and Vaadin 8.

*Disclaimer: I have only tested it with Vaadin 8. Please add an issue if it doesn’t work with Vaadin 7.*

It allows you to position the caption element of individual components inside `VerticalLayout` or `HorizontalLayout` to be either “top”, “right”, “bottom” or ”left”. It keeps any extra caption decorations (such as required field or error indicators) together with the caption (unline `FormLayout` for example, which moves the error indicator after the field).

```java
VerticalLayout layout = new VerticalLayout();
CaptionPositions captionPositions = new CaptionPositions(layout);
captionPositions.setCaptionPosition(component, CaptionPosition.LEFT);
```

## Online demo

Try the add-on demo at http://jouni.app.fi/captionpositions-demo

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/captionpositions

## Building and running demo

git clone https://github.com/jouni/captionpositions-for-vaadin
mvn clean install
cd demo
mvn jetty:run

To see the demo, navigate to http://localhost:8080/

## Development with Eclipse IDE

For further development of this add-on, the following tool-chain is recommended:
- Eclipse IDE
- m2e wtp plug-in (install it from Eclipse Marketplace)
- Vaadin Eclipse plug-in (install it from Eclipse Marketplace)
- JRebel Eclipse plug-in (install it from Eclipse Marketplace)
- Chrome browser

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine.

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases.

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.
