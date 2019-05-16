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
import './style/App.css';
import Date from './components/Date';
import LineChart from './components/charts/LineChart';
import StockTicker from './components/StockTicker';
import Form from './components/Form';
import Charts from './components/Charts';


/**
 * TODO:
 * Import your components
 */

class App extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
          //linechart: null,
          tick:'',
          start: '',
          end: ''
        }
        this.submit = Boolean(false);
        this.handleSubmit= this.handleSubmit.bind(this);
    }

    handleSubmit(star, en, ticker){
    console.log(this.submit);
    /*if ( this.state.linechart!= null){
      this.state.linechart.updateTitle(ticker);
    }*/
    this.submit = Boolean(true);
    this.setState({tick: ticker, start: star, end: en});
    console.log(this.submit);
    
    }

    render () {
      return (
          <div className="page-display">
              <div className="input">
                <Form onSubmit={this.handleSubmit}/>
              </div>
                {
                this.submit ? 
                (<span>  {<Charts name = {this.state.tick} start = {this.state.start} end = {this.state.end}  />} {this.submit = Boolean(false)}
                </span> ) : 
                (<span></span>)
                }

          </div>
      );
    }
}

export default App;
