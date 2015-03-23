	// requires basic type functions ( basicType.js )
	/* ---------------- Common form operations/ --------------- */

	// function to check required form element
	function fn_CheckRequired ( theElement , theElementName )
	{
		/*
		if ( theElement == undefined )
		{
			alert ( "Ҫ�������Ŀ��" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if( theElement.value == "" )
		{
			alert( "����д" + "\"" + theElementName + "\"!" ) ;
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
			alert ( "Ҫ�������Ŀ��" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		if( isNaN( parseInt ( theElement.value ) ) )
		{
			alert( "\"" + theElementName + "\"" + "����һ����Ч��������" ) ;
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
			alert ( "Ҫ�������Ŀ��" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		if( isNaN( parseFloat ( theElement.value ) ) )
		{
			alert( "\"" + theElementName + "\"" + "����һ����Ч�����֣�" ) ;
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
			alert ( "Ҫ�������Ŀ��" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		if( ! isEmail( theElement.value ) )
		{
			alert( "\"" + theElementName + "\"" + "����һ����Ч��E-mail��ַ��" ) ;
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
			alert ( "Ҫ�������Ŀ��" + thePasswordName1	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		if ( thePassword2 == undefined )
		{
			alert ( "Ҫ�������Ŀ��" + thePasswordName2	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		if ( thePassword1.value.length < 6 )
		{
			alert ( "\"" + thePasswordName1 + "\"����Ҫ��6���ַ���" ) ;
			thePassword1.value = "" ;
			thePassword1.focus ( ) ;
			return false ;
		}

		if ( thePassword2.value.length < 6 )
		{
			alert ( "\"" + thePasswordName2 + "\"����Ҫ��6���ַ���" ) ;
			thePassword2.value = "" ;
			thePassword2.focus ( ) ;
			return false ;
		}

		if ( thePassword1.value != thePassword2.value )
		{
			alert ( "������������벻���ϣ����������롣" )
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
			alert ( "Ҫ�������Ŀ��" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName + "\"������д��" ) ;
		  theElement.focus ( ) ;
		  return false ;
		}

		if ( ! fn_CheckLoginName ( theElement.value ) )
		{
			alert ( "\"" + theElementName + "\"��ֻ�ܰ�����ĸ�����ֺ�\"-\"��\".\"��\"_\"�ַ������Ҳ�����\"-\"��\".\"��\"_\"�ַ���ͷ��" ) ;
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
			alert ( "Ҫ�������Ŀ��" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName + "\"������д��" ) ;
		  theElement.focus ( ) ;
		  return false ;
		}

		if ( ! fn_CheckDomainName ( theElement.value ) )
		{
			alert ( "\"" + theElementName + "\"��ֻ�ܰ�����ĸ�����ֺ�\"-\"�ַ������Ҳ�����\"-\"�ַ���ͷ��" ) ;
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
			alert ( "Ҫ�������Ŀ��" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		theElement.value = trimString ( theElement.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName + "\"������д��" ) ;
		  theElement.focus ( ) ;
		  return false ;
		}

		if ( ! isIPAddress ( theElement.value ) )
		{
			alert ( "\"" + theElementName + "\"���ǺϷ���IP��ַ��" ) ;
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
			alert ( "Ҫ�������Ŀ��" + theElementName1	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		if ( theElement2 == undefined )
		{
			alert ( "Ҫ�������Ŀ��" + theElementName2	+ "��������һ����Ч��JavaScript����" ) ;
			return false;
		}
		*/
		theElement1.value = trimString ( theElement1.value ) ;
		if ( theElement.value == "" )
		{
		  alert ( "\"" + theElementName1 + "\"������д��" ) ;
		  theElement1.focus ( ) ;
		  return false ;
		}

		if ( ! isIPAddress ( theElement1.value ) )
		{
			alert ( "\"" + theElementName1 + "\"���ǺϷ���IP��ַ��" ) ;
			theElement1.focus ( ) ;
			return false ;
		}

		theElement2.value = trimString ( theElement2.value ) ;
		if ( theElement2.value == "" )
		{
		  alert ( "\"" + theElementName2 + "\"������д��" ) ;
		  theElement2.focus ( ) ;
		  return false ;
		}

		if ( ! isIPAddress ( theElement2.value ) )
		{
			alert ( "\"" + theElementName2 + "\"���ǺϷ���IP��ַ��" ) ;
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
			alert ( "Ҫ����д�ı���" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
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
			alert ( "Ҫ����д�ı��б�����һ����Ч��JavaScript����" ) ;
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
			return "<option value=\"1\" selected>��1ҳ</option>";

		nPages = Math.ceil( Number( nTotalCount ) / Number ( nItemPerPage ) ) ;

		nPage = Math.ceil( Number( nStartItem ) / Number ( nItemPerPage ) ) ;

		if( nPages > 1 )
		{
			strReturn = "<option value=\"1\">��ǰҳ</option>" ;
		}else
		{
			strReturn = "" ;
		}

		if( nPage > 10 )
		{
			strReturn += "<option value=\"" + (nPage-1) + "\">ǰ10ҳ</option>" ;
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

			strReturn += ">��" + (nLoopCount+1) + "ҳ</option>" ;
		}

		if( nPages > nEnd )
		{
			strReturn += "<option value=\"" + (nEnd+1) + "\">��10ҳ</option>" ;
		}

		if( nPages > 1 )
		{
			strReturn += "<option value=\"" + nPages + "\">���ҳ</option>" ;
		}

		return strReturn;
	}

	function fn_IsFormChanged( theForm )
	{
		/*
		if ( theForm == undefined )
		{
			alert ( "Ҫ����ı���" + theElementName	+ "��������һ����Ч��JavaScript����" ) ;
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
