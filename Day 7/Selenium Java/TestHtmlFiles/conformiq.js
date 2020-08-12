
function ShowCheckpoints()
{
	ShowDiv('hide_checkpoints');
    HideDiv('show_checkpoints');
    HideDiv('show_checkpointlocal');
    ShowDiv('hide_checkpointlocal');
    HideDiv('show_checkpointglobal');
    ShowDiv('hide_checkpointglobal');
    HideDiv('show_checkpointredundant');
    ShowDiv('hide_checkpointredundant');
    ShowRow('checkpoint');
}

function HideCheckpoints()
{
    ShowDiv('show_checkpoints');
    HideDiv('hide_checkpoints');
    HideRow('checkpoint');
}

function ShowRequirements()
{
 	ShowDiv('hide_requirements');
    HideDiv('show_requirements');
    HideDiv('show_requirementlocal');
    ShowDiv('hide_requirementlocal');
    HideDiv('show_requirementglobal');
    ShowDiv('hide_requirementglobal');
    HideDiv('show_requirementredundant');
    ShowDiv('hide_requirementredundant');
    ShowRow('requirement');
}


var showMode = 'table-cell';

// However, IE5 at least does not render table cells correctly
// using the style 'table-cell', but does when the style 'block'
// is used, so handle this

if (document.all) showMode='block';

// This is the function that actually does the manipulation

function toggleVis(btn){

	// First isolate the checkbox by name using the
	// name of the form and the name of the checkbox

	btn   = document.forms['tcol'].elements[btn];

	// Next find all the table cells by using the DOM function
	// getElementsByName passing in the constructed name of
	// the cells, derived from the checkbox name

	cells = document.getElementsByName('t'+btn.name);

	// Once the cells and checkbox object has been retrieved
	// the show hide choice is simply whether the checkbox is
	// checked or clear

	mode = btn.checked ? showMode : 'none';

	// Apply the style to the CSS display property for the cells

	for(j = 0; j < cells.length; j++) cells[j].style.display = mode;
}



function HideRequirements()
{
    ShowDiv('show_requirements');
    HideDiv('hide_requirements');
    HideRow('requirement');
}

function ShowDebugPrints()
{
    HideDiv('show_debugprints');
    ShowDiv('hide_debugprints');
    ShowRow('debugprints_row');
}

function HideDebugPrints()
{
    ShowDiv('show_debugprints');
    HideDiv('hide_debugprints');
    HideRow('debugprints_row');
}

function ShowGlobalCheckpoints()
{
    HideDiv('show_checkpointglobal');
    ShowDiv('hide_checkpointglobal');
    ShowRow('checkpointglobal_row');
}

function HideGlobalCheckpoints()
{
    ShowDiv('show_checkpointglobal');
    HideDiv('hide_checkpointglobal');
    HideRow('checkpointglobal_row');
}

function ShowLocalCheckpoints()
{
    HideDiv('show_checkpointlocal');
    ShowDiv('hide_checkpointlocal');
    ShowRow('checkpointlocal_row');
}

function HideLocalCheckpoints()
{
    ShowDiv('show_checkpointlocal');
    HideDiv('hide_checkpointlocal');
    HideRow('checkpointlocal_row');
}

function ShowRedundantCheckpoints()
{
    HideDiv('show_checkpointredundant');
    ShowDiv('hide_checkpointredundant');
    ShowRow('checkpointredundant_row');
}

function HideRedundantCheckpoints()
{
    ShowDiv('show_checkpointredundant');
    HideDiv('hide_checkpointredundant');
    HideRow('checkpointredundant_row');
}

function ShowGlobalRequirements()
{
    HideDiv('show_requirementglobal');
    ShowDiv('hide_requirementglobal');
    ShowRow('requirementglobal_row');
}

function HideGlobalRequirements()
{
    ShowDiv('show_requirementglobal');
    HideDiv('hide_requirementglobal');
    HideRow('requirementglobal_row');
}

function ShowLocalRequirements()
{
    HideDiv('show_requirementlocal');
    ShowDiv('hide_requirementlocal');
    ShowRow('requirementlocal_row');
}

function HideLocalRequirements()
{
    ShowDiv('show_requirementlocal');
    HideDiv('hide_requirementlocal');
    HideRow('requirementlocal_row');
}

function ShowRedundantRequirements()
{
    HideDiv('show_requirementredundant');
    ShowDiv('hide_requirementredundant');
    ShowRow('requirementredundant_row');
}

function HideRedundantRequirements()
{
    ShowDiv('show_requirementredundant');
    HideDiv('hide_requirementredundant');
    HideRow('requirementredundant_row');
}

function ShowCheckpointInfo()
{
    HideDiv('show_checkpointinfo');
    ShowDiv('hide_checkpointinfo');
}

function HideCheckpointInfo()
{
    ShowDiv('show_checkpointinfo');
    HideDiv('hide_checkpointinfo');
}

function ShowRequirementInfo()
{
    HideDiv('show_requirementinfo');
    ShowDiv('hide_requirementinfo');
}

function HideRequirementInfo()
{
    ShowDiv('show_requirementinfo');
    HideDiv('hide_requirementinfo');
}

function HideDiv(id)
{
    DoDiv(id, 'none');
}

function ShowDiv(id)
{
    DoDiv(id, '');
}

function DoDiv(id, visibility)
{
    var m = document.getElementById(id);
    if (m != null)
    {
        m.style.display = visibility;
    }
}
function Toggle(id)
{
    var x = document.getElementById(id).style.display;
    document.getElementById(id).style.display =
        (x == 'none' ? '' : 'none');
}

function HideRow(id)
{
    DoRow(id, 'none');
}

function ShowMatrix(id)
{
    var m = document.getElementById(id + "_matrix");
   
    if (m != null)
    {
        m.style.display = '';
        ShowDiv("hide_" + id + "_matrix");
        HideDiv("show_" + id + "_matrix");
    }
}

function HideMatrix(id)
{
    var m = document.getElementById(id + "_matrix");
    if (m != null)
    {
        m.style.display = 'none';
        HideDiv("hide_" + id + "_matrix");
        ShowDiv("show_" + id + "_matrix");
    }
}

function OnLoad()
{
    ShowMatrix('configuration');
    ShowMatrix('reqcoverage');
    ShowMatrix('requirement');
    ShowMatrix('testcaselist1');
    ShowMatrix('coverage');
  	ShowMatrix('dependency');
  	ShowMatrix('checkpoint');
  	
    
    var elems = document.getElementsByTagName("DIV");
    for (var i = 0; i < elems.length; i++)
    {
    
        if (!elems[i].id.match('_checkpoint_matrix') &&!elems[i].id.match('_dependency_matrix') &&!elems[i].id.match('_configuration_matrix') && !elems[i].id.match('_reqcoverage_matrix')&& !elems[i].id.match('_coverage_matrix')&&!elems[i].id.match('_requirement_matrix')&&!elems[i].id.match('_testcaselist1_matrix'))
        {
            if (elems[i].id.match('hide_record_'))
            {
                elems[i].style.display = 'none';
            }
            else if (elems[i].id.match('show_') &&
                     !elems[i].id.match('show_record_'))
            {
                elems[i].style.display = 'none';
            }
        }
    }
    // ResizeFont(0);
    HideDebugPrints();
    HideRequirements();
    HideCheckpoints();
    HideDiv('loading_page');
}

function ShowRow(id)
{
    DoRow(id, '');
}

function ShowRecords()
{
    var elems = document.getElementsByTagName("DIV");
    for (var i = 0; i < elems.length; i++)
    {
        if (elems[i].id.match('hide_record_'))
        {
            elems[i].style.display = '';
        }
        else if (elems[i].id.match('show_record_'))
        {
            elems[i].style.display = 'none';
        }
    }
}

function HideRecords()
{
    var elems = document.getElementsByTagName("DIV");
    for (var i = 0; i < elems.length; i++)
    {
        if (elems[i].id.match('hide_record_'))
        {
            elems[i].style.display = 'none';
        }
        else if (elems[i].id.match('show_record_'))
        {
            elems[i].style.display = '';
        }
    }
}

function DoRow(id, visibility)
{
    var elems = document.getElementsByTagName("TR");
    for (var i = 0; i < elems.length; i++)
    {
        if (elems[i].className.match(id))
        {
            elems[i].style.display = visibility;
        }
    }
    for (var i = 0; i < elems.length; i++)
    {
        var tables = elems[i].getElementsByTagName("TABLE");
        for (var j = 0; j < tables.length; j++)
        {
            var table = tables[j];
            var rows = table.getElementsByTagName("TR");
            var v = 0;
            for (var k = 0; k < rows.length; k++)
            {
                if (rows[k].style.display != 'none')
                {
                    v = 1;
                }
            }
            elems[i].style.display = (v == 0 ? 'none' : '');
        }
    }
}

function ResizeFont(adj)
{
    if (!document.getElementById)
    {
        return;
    }
    var body = document.getElementsByTagName('body')[0];
    var tags = body.getElementsByTagName('*');
    for (var i = 0; i < tags.length; i++)
    {
        var s = 14;
        if (tags[i].style.fontSize)
        {
            s = parseInt(tags[i].style.fontSize.replace('px','')) + adj;
        }
        else if (tags[i].nodeName == 'H1')
        {
            s = 22 + adj;
        }
        else if (tags[i].nodeName == 'H2')
        {
            s = 18 + adj;
        }
        tags[i].style.fontSize = s + 'px';
    }
}

function ShowRecord(id)
{
    ShowDiv("hide_record_" + id);
    HideDiv("show_record_" + id);
    ShowDiv("hide_record__nullomit" + id);
    HideDiv("show_record_nullomit" + id);
    
}

function HideRecord(id)
{
    ShowDiv("show_record_" + id);
    HideDiv("hide_record_" + id);
    ShowDiv("hide_record__nullomit" + id);
    HideDiv("show_record_nullomit" + id);
}
