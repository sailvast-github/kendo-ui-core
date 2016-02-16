---
title: Common Issues
page_title: Common Issues | Kendo UI Diagram Widget
description: "Learn how to deal with issues you may encounter while using the Kendo UI Diagram widget."
slug: troubleshooting_diagram_widget
position: 1
---

# Common Issues

This page provides solutions for common problems related to the Kendo UI Diagrams.

## Rendering

### Diagram Graphics Do Not Render in Internet Explorer

> **Important**
>
> A security message suggesting that you enable the Intranet settings might appear. If you choose to do so, then you do not need to follow the steps below.

**Solution**

Select **Internet Options** > **Security** > **Internet** (or **Local intranet**) > **Custom Level**  and enable **Binary and script behaviors** by ticking the **Enable** radio button.

**Figure 2. Options and settings to apply to render the chart graphics**

![IEscript behaviors](/styles-and-layout/chart-ie-script-behaviors.png)

## Export

### Layout Is Different in Exported PDF Files

Such issues are typically caused by the different fonts that are used on screen and in the PDF.

For display, the browser will substitute the selected font with whatever is provided by the system. During export, you will take the metrics from the actual font in use and determine the PDF layout from that. It is likely that the resulting PDF will be displayed with a different font, leading to layout and encoding issues.

**Solution**

The solution is to [make the fonts available for embedding]({% slug pdfderawingexport_drawingapi %}#configuration-Custom). This means that the fonts should be available as binary TTF files and registered for export.

This is demonstrated in the [PDF Export demo on Diagram](http://demos.telerik.com/kendo-ui/diagram/pdf-export) as well.

The example below demonstrates how to embed fonts in exported PDF.

###### Example

```html
<button class='export-pdf k-button'>Save as PDF</button>

<div id="diagram"></div>

<script>
    // Import DejaVu Sans font for embedding

    kendo.pdf.defineFont({
        "DejaVu Sans"             : "https://kendo.cdn.telerik.com/2016.1.112/styles/fonts/DejaVu/DejaVuSans.ttf",
        "DejaVu Sans|Bold"        : "https://kendo.cdn.telerik.com/2016.1.112/styles/fonts/DejaVu/DejaVuSans-Bold.ttf",
        "DejaVu Sans|Bold|Italic" : "https://kendo.cdn.telerik.com/2016.1.112/styles/fonts/DejaVu/DejaVuSans-Oblique.ttf",
        "DejaVu Sans|Italic"      : "https://kendo.cdn.telerik.com/2016.1.112/styles/fonts/DejaVu/DejaVuSans-Oblique.ttf"
    });
</script>

<!-- Load Pako ZLIB library to enable PDF compression -->
<script src="//kendo.cdn.telerik.com/2016.1.112/js/pako_deflate.min.js"></script>

<script>
    $(".export-pdf").click(function() {
        $("#diagram").getKendoDiagram().saveAsPDF();
    });

    function createDiagram() {
        var data = [{
            firstName: "Antonio",
            lastName: "Moreno",
            image: "antonio.jpg",
            title: "Team Lead",
            colorScheme: "#1696d3",
            items: [{
                firstName: "Elizabeth",
                image: "elizabeth.jpg",
                lastName: "Brown",
                title: "Design Lead",
                colorScheme: "#ef6944",
                items: [{
                    firstName: "Ann",
                    lastName: "Devon",
                    image: "ann.jpg",
                    title: "UI Designer",
                    colorScheme: "#ef6944"
                }]
            }, {
                firstName: "Diego",
                lastName: "Roel",
                image: "diego.jpg",
                title: "QA Engineer",
                colorScheme: "#ee587b",
                items: [{
                    firstName: "Fran",
                    lastName: "Wilson",
                    image: "fran.jpg",
                    title: "QA Intern",
                    colorScheme: "#ee587b"
                }]
            }, {
                firstName: "Felipe",
                lastName: "Izquiedro",
                image: "felipe.jpg",
                title: "Senior Developer",
                colorScheme: "#75be16",
                items: [{
                    firstName: "Daniel",
                    lastName: "Tonini",
                    image: "daniel.jpg",
                    title: "Developer",
                    colorScheme: "#75be16"
                }]
            }]
        }];

        function visualTemplate(options) {
            var dataviz = kendo.dataviz;
            var g = new dataviz.diagram.Group();
            var dataItem = options.dataItem;

            g.append(new dataviz.diagram.Rectangle({
                width: 210,
                height: 75,
                stroke: {
                    width: 0
                },
                fill: dataItem.colorScheme
            }));

            g.append(new dataviz.diagram.TextBlock({
                text: dataItem.firstName + " " + dataItem.lastName,
                fontFamily: "DejaVu, sans-serif",
                x: 10,
                y: 20,
                fill: "#fff"
            }));

            g.append(new dataviz.diagram.TextBlock({
                text: dataItem.title,
                fontFamily: "DejaVu, sans-serif",
                x: 10,
                y: 40,
                fill: "#fff"
            }));

            return g;
        }

        $("#diagram").kendoDiagram({
            dataSource: new kendo.data.HierarchicalDataSource({
                data: data,
                schema: {
                    model: {
                        children: "items"
                    }
                }
            }),
            layout: {
                type: "layered"
            },
            shapeDefaults: {
                visual: visualTemplate
            },
            connectionDefaults: {
                stroke: {
                    color: "#979797",
                    width: 2
                }
            }
        });

        var diagram = $("#diagram").getKendoDiagram();
        diagram.bringIntoView(diagram.shapes);
    }

    $(document).ready(createDiagram);
</script>
```

## See Also

Other articles on styling, appearance, and rendering of Kendo UI widgets:

* [Themes and Appearance of the Kendo UI Widgets]({% slug themesandappearnce_kendoui_desktopwidgets %})
* [Rendering Modes for Data Visualization]({% slug renderingmodesfor_datavisualization_kendouistyling %})

Other articles on troubleshooting:

* [JavaScript Errors]({% slug troubleshooting_javascript_errors_kendoui %})
* [Performance Issues]({% slug troubleshooting_system_memory_symptoms_kendoui %})
* [Content Security Policy]({% slug troubleshooting_content_security_policy_kendoui %})
* [Common Issues in Telerik UI for ASP.NET MVC](/aspnet-mvc/troubleshooting)