{
    title: {
        text:'${title}',
        x:'middle',
        textAlign:'center'
    },
    xAxis: {
        type: 'category',
        data: ${categories}
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: ${values},
        type: 'bar'
    }]
}
