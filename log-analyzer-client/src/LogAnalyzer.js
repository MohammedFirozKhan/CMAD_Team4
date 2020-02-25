import React from 'react';

class SearchForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = { startDate: '', endDate : '', pageSize: '', logLevel: '' }
    console.log('Am here')
    this.startDate = (startDate) => this.setState({ startDate: startDate.target.value })
    this.endDate = (endDate) => this.setState({ endDate: endDate.target.value })
    this.logLevel = (logLevel) => this.setState({ logLevel: logLevel.target.value })
    
    this.onSearch = () => {
       this.props.onSearchByDateTime(this.state.startDate,this.state.endDate,this.state.logLevel);
    }
 }
  render() {
    return (
      <div>
        <table>
        <tbody>
          <tr><td><i>Start Date: </i><input type="date" value={this.state.startDate} onChange={this.startDate} /></td></tr>
          <tr><td>End Date: <input type="date" value={this.state.endDate} onChange={this.endDate} /></td></tr>
          <tr><td>Log Level: <input type="text" value={this.state.logLevel} onChange={this.logLevel} /></td></tr>
          <tr><td><button onClick={this.onSearch}>{this.props.label}</button></td></tr>
        </tbody>
      </table>
      </div>
    );
  }
}

class SearchResults extends React.Component {
  render() {
    return (
       <table width='100%'>
          <tbody>
              <tr style={{backgroundColor: 'black', color: 'white'}}><th>Date</th><th>Host Name</th><th>Log Msg</th><th>Log Level</th><th>Process Name</th></tr>
              {
                this.props.results.map((log,i) => <tr key ={i}><td>{log.date}</td><td>{log.hostName}</td><td>{log.logMsg}</td><td>{log.logLevel}</td><td>{log.processName}</td></tr>)
              }
          </tbody>
       </table>
    )
  }
}

class LogAnalyzer extends React.Component {
  constructor(props) {
    super(props);
    this.state = { results: [] }

    this.onSearchByDateTime = (startDate,endDate,logLevel) => {
       //console.log('http://localhost:8080/logsBetween/?startDate=${startDate}&endDate=${endDate}&logLevel=${logLevel}&page=0&size=50')

       fetch(`http://localhost:8080/logsBetween/?startDate=${startDate}&endDate=${endDate}&logLevel=${logLevel}&page=0&size=50`).then(response => {
          response.json().then(logs => {
             this.setState({
                results: logs
             })
          })
       })
    }
 }
 render() {
    console.log('Inside render')
    return (
       <div>
          <h1>Log Analyzer</h1>
          <hr/>
          <SearchForm onSearchByDateTime={this.onSearchByDateTime} label="Search By Date N Time" />
          <hr/>
          <h3>Search Results</h3>
          <SearchResults results={this.state.results}/>
       </div>
    )
 }
}
export default LogAnalyzer;
