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

/**
 * TODO:
 * Import your components
 */


class App extends React.Component{
    

    constructor(props) {
        super(props);
        this.state ={
          linechart: null
        }
        this.handleSubmit= this.handleSubmit.bind(this);
    }
    handleSubmit(start, end, ticker){
      this.submit = Boolean(true);
    this.setState({linechart : <LineChart name = {ticker}/>});
    }

    render () {
      return (
                
          <div className="page-display">
              <div className="input">
                
                <div className="date-range">
                <Form onSubmit={this.handleSubmit}/>
                </div>

                {
                this.submit ? 
                (<span>  {this.state.linechart} </span>) : 
                (<span></span>)
                }
                

              </div>
              

          </div>
      );
    }
}

export default App;
