/**
 * Copyright 2019 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import React from 'react';
import Highcharts from 'highcharts';


class LineChart extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
        highchartsOptions: {
          title: {
            text: props.name
          },
          xAxis: {
            categories: props.xaxis
          },
          yAxis: {
            title: {
              text: 'Price'
            }
          },
          series: [{
            name: props.name,
            marker: {
              symbol: 'square'
            },
            data: props.data
    
          }]
        }
      }
    }

    componentDidMount() {
        this.setState(
        {highchartsOptions: {
        series: [{
          data: [Math.random() * 5, Math.random() * 5, Math.random() * 5]
          }]
      }});
        Highcharts.chart('chart', this.state.highchartsOptions);
    }

    componentWillReceiveProps(nextProps) {
      console.log("New data received to redraw chart.");
      
      /**
       * TODO
       * Parse the data received from props, a Javascript object, to map to a Javascript array
       * required by the type of line chart chosen and set it in the series. Use Date.UTC(..)
       * to create the x-axis.
       */
      
      /**
       * TODO
       * Uncomment the line below to pass the data be displayed to the series*/
      this.setState(
        {highchartsOptions: {
        title: {
          text: nextProps.name
        },
        xAxis: {
          categories: nextProps.xaxis
        },
        yAxis: {
          title: {
            text: 'Price'
          }
        },
        series: [{
          name: nextProps.name,
          marker: {
            symbol: 'square'
          },
          data: nextProps.data
          }]
      }});
        /*this.chart.setTitle({text: props.name});
       this.chart.series[0].setData(props.data); */
  }


    componentWillUnmount() {
        this.chart.destroy();
    }


    render() {
        return (
            <div id='chart'></div>
        )
    }
}

// Don't forget to export your component!
export default LineChart
