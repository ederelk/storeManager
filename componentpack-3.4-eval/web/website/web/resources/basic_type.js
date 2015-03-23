// common JavaScript functions

	/* ---------------- Common basic type operations/ --------------- */
	// serial of functions to trim string
	var whitespace = " \t\n\r";

	function charInString (c, s)
	{   for (i = 0; i < s.length; i++)
		{   if (s.charAt(i) == c) return true;
		}
		return false
	}

	function stripInitialWhitespace (s)
	{   var i = 0;

		while ((i < s.length) && charInString (s.charAt(i), whitespace))
		   i++;

		return s.substring (i, s.length);
	}

	function stripEndingWhitespace (s)
	{   var i = s.length - 1;

		while ((i > 0) && charInString (s.charAt(i), whitespace))
		   i--;

		return s.substring (0, i+1);
	}

	function trimString (s)
	{
		return stripEndingWhitespace ( stripInitialWhitespace (s) );

	}

	// function to check E-mail address like string
	function isEmail (s)
	{
		// there must be >= 1 character before @, so we
		// start looking at character position 1
		// (i.e. second character)
		var i = 1;
		var sLength = s.length;

		if ( sLength <= 1 ) return false ;

		// look for @
		while ((i < sLength) && (s.charAt(i) != "@"))
		{ i++
		}

		if ((i >= sLength) || (s.charAt(i) != "@")) return false;
		else i += 2;

		// look for .
		while ((i < sLength) && (s.charAt(i) != "."))
		{ i++
		}

		// there must be at least one character after the .
		if ((i >= sLength - 1) || (s.charAt(i) != ".")) return false;
		else return true;
	}

	// function to check IP Address like string
	function isIPAddress ( strIPAddress )
	{
		regExp = new RegExp ( "([0-9]{1,3})[\.]{1,}([0-9]{1,3})[\.]{1,}([0-9]{1,3})[\.]{1,}([0-9]{1,3})" ) ;
		aParts = regExp.exec ( strIPAddress ) ;
		if ( aParts == null )
		{
			return false ;
		}

		if ( aParts.length != 5 )
		{
			return false ;
		}

		for ( nLoopCnt = 1 ; nLoopCnt < 5 ; nLoopCnt ++ )
		{
			if ( aParts [ nLoopCnt ] < 0 || aParts [ nLoopCnt ] > 255 )
			{
				return false ;
			}
		}

		return true ;
	}

	// function to check login name like string
	function fn_CheckLoginName ( strLogin )
	{
		strLogin = trimString( strLogin ) ;

		var checkOK = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._";
		var checkStr = strLogin ;
		var allValid = true;
		for (i = 0;  i < checkStr.length;  i++)
		{
			ch = checkStr.charAt(i);
			for (j = 0;  j < checkOK.length;  j++)
			  if (ch == checkOK.charAt(j))
				break;
			if (j == checkOK.length)
			{
			  allValid = false;
			  break;
			}
		}
		if ( ! allValid )
		{
			return (false);
		}

		if ( checkStr.charAt(0) == '-' || checkStr.charAt(0) == '.' || checkStr.charAt(0) == '_' )
		{
			return (false);
		}

		return (true);
	}

	// function to check Domain name like string
	function fn_CheckDomainName ( strDomainName )
	{
		strDomainName = trimString ( strDomainName ) ;

		var checkOK = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-.";
		var checkStr = strDomainName;
		var allValid = true;
		for (i = 0;  i < checkStr.length;  i++)
		{
			ch = checkStr.charAt(i);
			for (j = 0;  j < checkOK.length;  j++)
			  if (ch == checkOK.charAt(j))
				break;
			if (j == checkOK.length)
			{
			  allValid = false;
			  break;
			}
		}
		if (!allValid)
		{
			return (false);
		}

		if ( checkStr.charAt(0) == '-' || checkStr.charAt(0) == '.' )
		{
			return (false);
		}

		return (true);
	}

	// function to check year, month, day numbers
	function fn_ValidateDate ( nYear , nMonth , nDay )
	{
		if ( nMonth < 1 || nMonth > 12 ) return false ;
		if ( nDay < 1 || nDay > 31 ) return false ;
		if ( nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11 )
		{
			if ( nDay > 30 ) return false ;
		}
		if ( nMonth == 2 )
		{
			if ( nYear % 4 == 0 )
			{
				if ( nYear % 100 == 0 )
				{
					if ( nYear % 400 == 0 )
					{
						if ( nDay > 29 ) return false ;
					}
					else
					{
						 if ( nDay > 28 ) return false ;
					}
				}
				else
				{
					if ( nDay > 29 ) return false ;
				}
			}
			else
			{
				if ( nDay > 28 ) return false ;
			}
		}

		return true ;
	}

	/* ---------------- /Common basic type operations --------------- */

