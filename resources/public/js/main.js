/** @jsx React.DOM */

var ButtonBar = React.createClass({//{{{
    render: function() {
        var prefix = "btn btn-"
        var blocked_button  = prefix + ((this.props.mode === "blocked")  ? "primary" : "default");
        var blocking_button = prefix + ((this.props.mode === "blocking") ? "primary" : "default");
        return (
            <div className="btn-group btn-group-justified">
                <div className="btn-group">
                    <button type="button" className={blocked_button} onClick={this.props.toggleUI}>I'm Blocked</button>
                </div>
                <div className="btn-group">
                    <button type="button" className={blocking_button} onClick={this.props.toggleUI}>I'm Blocking</button>
                </div>
            </div>
        );
    }
});//}}}

var BlockedSearch = React.createClass({//{{{
    render: function() {
        return (
            <form role="form">
                <div className="form-group">
                    <label htmlFor="lic_or_tag" className="control-label">Licence Plate or Tag Number</label>
                    <input type="text" type="lic_or_tag" className="form-control" id="lic_or_tag" placeholder="1ABC456 or 1234"/>
                </div>
                <div className="btn-group btn-group-justified">
                    <div className="btn-group">
                        <button type="submit" className="btn btn-default">Search </button>
                    </div>
                </div>
            </form>
        );
    }
});//}}}

var BlockingSearch = React.createClass({//{{{
    render: function() {
        return (
            <form role="form">
                <div className="form-group">
                    <label htmlFor="lic_or_tag" className="control-label">Licence Plate or Tag Number</label>
                    <input type="text" type="lic_or_tag" className="form-control" id="lic_or_tag" placeholder="1ABC456 or 1234"/>
                </div>
                <div className="form-group">
                    <label htmlFor="name" className="control-label">Your Name</label>
                    <input type="text" type="name" className="form-control" id="name" placeholder="John Doe"/>
                </div>
                <div className="form-group">
                    <label htmlFor="leaving" className="control-label">When are you leaving (optional)</label>
                    <input type="text" type="leaving" className="form-control" id="leaving" placeholder="John Doe"/>
                </div>
                <div className="btn-group btn-group-justified">
                    <div className="btn-group">
                        <button type="submit" className="btn btn-default">Search </button>
                    </div>
                </div>
            </form>
        );
    }
});//}}}

var TopLevel = React.createClass({//{{{
    getInitialState: function() {
        return { mode: "blocked" }
    },
    toggleUI: function() {
        var newMode = this.state.mode === 'blocked' ? 'blocking' : 'blocked';
        console.log("test");
        this.setState({mode: newMode});
    },
    render: function() {
        var comp = this.state.mode === "blocked" ? <BlockedSearch/> :  <BlockingSearch/>;
        return (
            <div>
                <ButtonBar mode={this.state.mode} toggleUI={this.toggleUI}/>
                {comp}
            </div>
        );
    }
});//}}}

React.renderComponent(
    <TopLevel/>,
    document.getElementById('main')
);
