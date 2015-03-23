	// requires basic type functions ( basicType.js )
	/* ---------------- Common form operations/ --------------- */

	// function to check required form element
	function fn_CheckRequired ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Item to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if( theElement.value == "" )
		{
			alert( "\"" + theElementName + "\"" + " is required!" ) ;
			theElement.focus();
			return false ;
		}
		return true;
	}

	// function to check INT form element
	function fn_CheckIntNumber ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Item to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		if( isNaN( parseInt ( theElement.value ) ) )
		{
			alert( "\"" + theElementName + "\"" + " is not a valid integer!" ) ;
			theElement.focus();
			return false ;
		}
		return true;
	}

	// function to check Float form element
	function fn_CheckFloatNumber ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Item to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		if( isNaN( parseFloat ( theElement.value ) ) )
		{
			alert( "\"" + theElementName + "\"" + " is not a valid number!" ) ;
			theElement.focus();
			return false ;
		}
		return true;
	}

	// function to check Email form element
	function fn_CheckEmail ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Item to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		if( ! isEmail( theElement.value ) )
		{
			alert( "\"" + theElementName + "\"" + " is not a valid E-mail address!" ) ;
			theElement.focus();
			return false ;
		}
		return true;
	}

	// function to check if 2 password match
	function fn_ValidatePassword ( thePassword1 , thePasswordName1 , thePassword2 , thePasswordName2 )
	{
		/*
		if ( thePassword1 == undefined )
		{
			alert ( "Item to check(" + thePasswordName1	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		if ( thePassword2 == undefined )
		{
			alert ( "Item to check(" + thePasswordName2	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		if ( thePassword1.value.length < 6 )
		{
			alert ( "\"" + thePasswordName1 + "\" must have at least 6 characters!" ) ;
			thePassword1.value = "" ;
			thePassword1.focus ( ) ;
			return false ;
		}

		if ( thePassword2.value.length < 6 )
		{
			alert ( "\"" + thePasswordName2 + "\" must have at least 6 characters!" ) ;
			thePassword2.value = "" ;
			thePassword2.focus ( ) ;
			return false ;
		}

		if ( thePassword1.value != thePassword2.value )
		{
			alert ( "Passwords don't match!" )
			thePassword1.value = "" ;
			thePassword2.value = "" ;
			thePassword1.focus ( ) ;
			return false ;
		}
		return true ;
	}

	// function to check valid login name
	function fn_ValidateLoginName ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Item to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName + "\" is required!" ) ;
		  theElement.focus ( ) ;
		  return false ;
		}

		if ( ! fn_CheckLoginName ( theElement.value ) )
		{
			alert ( "\"" + theElementName + "\" can only contains letters, digits, \"-\", \".\", \"_\" symbols, and can not start with symbols!" ) ;
			theElement.focus ( ) ;
			return false ;
		}
		return true ;
	}

	// function to check valid domain name
	function fn_ValidateDomainName ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Item to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName + "\" is required!" ) ;
		  theElement.focus ( ) ;
		  return false ;
		}

		if ( ! fn_CheckDomainName ( theElement.value ) )
		{
			alert ( "\"" + theElementName + "\" can only contains letters, digits, \"-\" symbol, and can not start with symbol!" ) ;
			theElement.focus ( ) ;
			return false ;
		}
		return true ;
	}

	// function to check valid ip address
	function fn_ValidateIPAddress ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Item to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName + "\" is required!" ) ;
		  theElement.focus ( ) ;
		  return false ;
		}

		if ( ! isIPAddress ( theElement.value ) )
		{
			alert ( "\"" + theElementName + "\" is not a valid IP address!" ) ;
			theElement.focus ( ) ;
			return false ;
		}
		return true ;
	}

	// function to check valid ip address Group
	function fn_ValidateIPAddressGroup ( theElement1 , theElementName1 , theElement2 , theElementName2 )
	{
		/*
		if ( theElement1 == undefined )
		{
			alert ( "Item to check(" + theElementName1	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		if ( theElement2 == undefined )
		{
			alert ( "Item to check(" + theElementName2	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		theElement1.value = trimString ( theElement1.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName1 + "\" is required!" ) ;
		  theElement1.focus ( ) ;
		  return false ;
		}

		if ( ! isIPAddress ( theElement1.value ) )
		{
			alert ( "\"" + theElementName1 + "\" is not a valid IP address!" ) ;
			theElement1.focus ( ) ;
			return false ;
		}

		theElement2.value = trimString ( theElement2.value ) ;
		if ( theElement2.value == "" )
		{
		  alert ( "\"" + theElementName2 + "\" is required!" ) ;
		  theElement2.focus ( ) ;
		  return false ;
		}

		if ( ! isIPAddress ( theElement2.value ) )
		{
			alert ( "\"" + theElementName2 + "\" is not a valid IP address!" ) ;
			theElement2.focus ( ) ;
			return false ;
		}
		return true ;
	}

	// function to check or uncheck all checkbox elements of a form by a select-all checkbox value
	function fn_ChangeSelectAll( theForm , bSelected )
	{
		/*
		if ( theForm == undefined )
		{
			alert ( "HTML form to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		for ( i = 0 ; i < theForm.elements.length ; i ++ )
		{
			obj = theForm.elements[i] ;
			if ( obj.type == "checkbox" )
			{
				obj.checked = bSelected ;
			}
		}
	}

	// function to set selected option of select form element by given option value
	function fn_FillSelectInput ( theSelectInput , strSelectedValue )
	{
		/*
		if ( theSelectInput == undefined )
		{
			alert ( "HTML form to check is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		for ( i = 0 ; i < theSelectInput.length ; i ++ )
		{
			if ( theSelectInput.options [ i ].value == strSelectedValue )
			{
				theSelectInput.options[i].selected = true ;
				break ;
			}
		}
	}

	// function to build select input options of an object list
	function fn_BuildOptions( nTotalCount , nItemPerPage , nStartItem )
	{
		if( nItemPerPage == -1 )
			return "<option value=\"1\" selected>Page 1</option>";

		nPages = Math.ceil( Number( nTotalCount ) / Number ( nItemPerPage ) ) ;

		nPage = Math.ceil( Number( nStartItem ) / Number ( nItemPerPage ) ) ;

		if( nPages > 1 )
		{
			strReturn = "<option value=\"1\">First page</option>" ;
		}else
		{
			strReturn = "" ;
		}

		if( nPage > 10 )
		{
			strReturn += "<option value=\"" + (nPage-1) + "\">Last 10</option>" ;
			nStart = nPage-1 ;
		}else
		{
			nStart = 0 ;
		}

		nEnd = Math.min( nPages , nStart + 10 ) ;
		//alert(nStart);
		//alert(nEnd);
		for( nLoopCount = nStart ; nLoopCount < nEnd ; nLoopCount++ )
		{
			strReturn += "<option value=\"" + (nLoopCount+1) + "\"" ;

			if( nLoopCount == nPage-1 )
				strReturn += " selected " ;

			strReturn += ">Page " + (nLoopCount+1) + "</option>" ;
		}

		if( nPages > nEnd )
		{
			strReturn += "<option value=\"" + (nEnd+1) + "\">Next 10</option>" ;
		}

		if( nPages > 1 )
		{
			strReturn += "<option value=\"" + nPages + "\">Last page</option>" ;
		}

		return strReturn;
	}

	function fn_IsFormChanged( theForm )
	{
		/*
		if ( theForm == undefined )
		{
			alert ( "HTML form to check(" + theElementName	+ ") is not a valid JavaScript Object" ) ;
			return false;
		}
		*/
		var i;
		var obj;
		for( i=0; i<theForm.elements.length; i++ )
		{
			obj = theForm.elements[i];
			if( obj.type == "text" )
			{
				if( obj.value != obj.defaultValue )
					return true;
			}else if( obj.type == "checkbox" )
			{
				if( obj.checked != obj.defaultChecked )
					return true;
			}else if( obj.type == "select-one" )
			{
				if( !obj.options[obj.selectedIndex].defaultSelected )
					return true;
			}else if( obj.type == "radio" )
			{
				if (obj.defaultChecked!=obj.checked)
				{
					return true;
				}
			}
		}

		return false;
	}
	/* ---------------- /Common form operations --------------- */
