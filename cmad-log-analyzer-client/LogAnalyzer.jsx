import React from "react";

class SearchFormByDays extends React.Component {
  constructor(props) {
    super(props);
    this.state = { days: "1", logLevel: "ALL" };

    this.onDaysChange = e =>
      this.setState({ days: e.target.value, logLevel: this.state.logLevel });
    this.onLogLevelChange = e =>
      this.setState({ days: this.state.days, logLevel: e.target.value });

    this.onSearch = () => {
      this.props.onSearch(this.state.days, this.state.logLevel);
      this.setState({ days: "1", logLevel: "ALL" });
    };
  }
  render() {
    return (
      <table>
        <tbody>
          <tr>
            <td>Enter Days </td>
            <td>
              <input value={this.state.days} onChange={this.onDaysChange} />
            </td>
            <td>
              <button onClick={this.onSearch}>{this.props.label}</button>
            </td>
          </tr>
          <tr>
            <td>Log Level </td>
            <td>
              <input
                value={this.state.logLevel}
                onChange={this.onLogLevelChange}
              />
            </td>
          </tr>
        </tbody>
      </table>
    );
  }
}

class SearchResults extends React.Component {
  render() {
    return (
      <table width="100%">
        <tbody>
          <tr style={{ backgroundColor: "black", color: "white" }}>
            <th>Date</th>
            <th>Host Name</th>
            <th>Log Level</th>
            <th>Process Name</th>
            <th>Log Message</th>
          </tr>
          {this.props.results.map(log => (
            <tr>
              <td>{log.date}</td>
              <td>{log.hostName}</td>
              <td>{log.logLevel}</td>
              <td>{log.processName}</td>
              <td>{log.logMsg}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

class LogStats extends React.Component {
  render() {
    return (
      <table width="100%">
        <tbody>
          <tr style={{ backgroundColor: "black", color: "white" }}>
            <th>Log Level</th>
            <th>Count</th>
          </tr>
          {this.props.statsResults.map(stats => (
            <tr>
              <td>{stats.logLevel}</td>
              <td>{stats.logCount}</td>
            </tr>
          ))}
        </tbody>
      </table>
    );
  }
}

class LogAnalyzer extends React.Component {
  constructor(props) {
    super(props);
    this.state = { results: [], statsResults: [] };

    this.onSearchByDate = (startDate, endDate, logLevel) => {
      fetch(
        `http://localhost:8080/logsBetween?startDate=${startDate}&endDate=${endDate}&logLevel=${logLevel}&page=0&size=10`
      ).then(response => {
        response.json().then(logs => {
          this.setState({
            results: logs
          });
        });
      });
    };

    this.onSearchByDays = (numberOfDays, logLevel) => {
      fetch(
        `http://localhost:8080/logs/?interval=${numberOfDays}&logLevel=${logLevel}&page=0&size=100`
      ).then(response => {
        response.json().then(logs => {
          this.setState({
            results: logs
          });
        });
      });

      fetch(`http://localhost:8080/stats/?interval=${numberOfDays}`).then(
        response => {
          response.json().then(stats => {
            this.setState({
              statsResults: stats
            });
          });
        }
      );
    };
  }
  render() {
    return (
      <div>
        <h1>Log Analyzer</h1>
        <hr />

        <SearchFormByDays
          onSearch={this.onSearchByDays}
          label="Search by Days"
          label2="LOG LEVEL"
        />
        <hr />
        <h3>Search Results</h3>
        <SearchResults results={this.state.results} />
        <h3>Log Stats</h3>
        <LogStats statsResults={this.state.statsResults} />
      </div>
    );
  }
}

export default LogAnalyzer;
