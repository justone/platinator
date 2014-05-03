/** @jsx React.DOM */
React.renderComponent(
    <div>
        <div className="col-md-9">
            <form className="form-horizontal">
                <fieldset>

                <div className="control-group">
                    <div className="input-group">
                      <span className="input-group-addon">License or Tag</span>
                      <input type="text" className="form-control" placeholder="1ABC456 or 1234"/>
                    </div>
                </div>

                <div className="control-group">
                  <label className="control-label" htmlFor="singlebutton"></label>
                  <div className="controls">
                    <button id="singlebutton" name="singlebutton" className="btn btn-default">Search</button>
                  </div>
                </div>

                </fieldset>
            </form>
        </div>

    </div>,
    document.getElementById('main')
);
