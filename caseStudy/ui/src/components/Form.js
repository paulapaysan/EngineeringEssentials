import React from 'react';
import Date from './Date';
import LineChart from './charts/LineChart';
import StockTicker from './StockTicker'

/**
 * TODO:
 * Import your components
 */


class Form extends React.Component{
    

    constructor(props) {
        super(props);
        this.state = {
              startDate : props.startDate,
              endDate : props.endDate,
              StockTicker: props.StockTicker,
        };
        this.handleSubmit= this.handleSubmit.bind(this);
        this.handleDateChange= this.handleDateChange.bind(this);
        this.handleTickerChange= this.handleTickerChange.bind(this);
    }
    handleSubmit(event){
        //event.preventDefault();
        this.props.onSubmit(this.state.startDate, this.state.endDate, this.state.StockTicker);
    }

    handleDateChange(start, end){
        this.setState({startDate: start, endDate: end});
    }

    handleTickerChange(ticker){
        this.setState({StockTicker: ticker});
    }


    render () {
      return (
          <div className="page-display">
                
                <div className="date-range">
                <Date onChange = {this.handleDateChange}/>
                <StockTicker label = "Stock Ticker" onChange = {this.handleTickerChange}/>
                <button className='btn btn-primary' onClick={this.handleSubmit}>Submit</button>
                </div>
          </div>
      );
    }
}

export default Form;