

import React from 'react';
import DatePicker from 'react-datepicker';
import moment from 'moment';
import 'react-datepicker/dist/react-datepicker.css';

class Date extends React.Component {
    constructor (props) {
        super(props)
        this.state = {
            startDate: moment(),
            endDate: moment()
        };
        this.handleChangeStart = this.handleChangeStart.bind(this);
        this.handleChangeEnd = this.handleChangeEnd.bind(this);

    }

    componentDidMount() {
        this.props.onChange(this.state.date);
    }

    handleChangeStart(date) {
    
         this.setState({startDate:date});
         this.props.onChange(date);
    }

     handleChangeEnd(date) {
             this.setState({endDate:date});
             this.props.onChange(date);
        }

    render() {
        return (
            <div className="date">
                
                <div className="date-input">
                <p><strong>{"Start Date"}</strong></p>
                    <DatePicker onChange={this.handleChangeStart} selected={this.state.startDate}/>
                </div>
                <div className="date-input">
                <p><strong>{"End Date"}</strong></p>
                     <DatePicker onChange={this.handleChangeEnd} selected={this.state.endDate}/>
                </div>
            </div>
        );
    }


}

// Don't forget to export your component!
export default Date
